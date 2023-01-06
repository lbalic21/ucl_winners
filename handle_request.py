from flask import Flask
import psycopg2
import json
import csv
app = Flask(__name__)

@app.route('/', methods = ['GET'])
def index():
   

#connection to database
    connection = psycopg2.connect(user="postgres",
                                  password="postgres",
                                  host="127.0.0.1",
                                  database="champions_league_winners")
    cursor = connection.cursor()

    cursor.execute('''UPDATE ucl_winner 
        SET scorers='{3}'
        WHERE scorers is null''')
    
    cursor.execute('''SELECT *
    FROM ucl_winner
    
    JOIN coach ON ucl_winner.head_coach = coach.id
    JOIN player capt ON ucl_winner.captain = capt.id
    JOIN player scor ON ucl_winner.scorers[1]= scor.id or ucl_winner.scorers[2]= scor.id or ucl_winner.scorers[3]= scor.id or ucl_winner.scorers[4]= scor.id''')
    
    result = cursor.fetchall()
    final = []
    for r in result :
        temp = []
        for i in range(12) :
            if(i < 5) :
                temp.append(r[i])
            if(i == 5) :
                t = []
                t.append(r[12])
                t.append(r[13])
                temp.append(t)
            if(i == 6) :
                t = []
                t.append(r[15])
                t.append(r[16])
                t.append(r[17])
                temp.append(t)
            if(i == 7 or i == 8) :
                temp.append(r[i])
            if(i == 9) :
                t = []
                t1 = []
                t.append(r[19])
                t.append(r[20])
                t.append(r[21])
                t1.append(t)
                temp.append(t1)
            if(i == 10) :
                temp.append(r[i])
        final.append(temp)
    
    
    #Export to CSV
    to_csv_temp = final
    to_csv = []
    for c in to_csv_temp :
        temp = []
        for i in range(len(c)) :
            if (i < 4 or (i > 6 and i < 9) or i > 9) :
                temp.append(c[i])
            if (i == 4) :
                temp.append(c[i])
            if (i == 5 or i == 6) :
                temp.append(c[i][0])
                temp.append(c[i][1])
            if (i == 9) :
                for player in c[i] :
                    temp.append(player[0])
                    temp.append(player[1])
                    temp.append(player[2])
        to_csv.append(temp)
    
    with open('ucl_winners.csv', 'w') as file:
        writer = csv.writer(file)
        writer.writerows(to_csv)
    
    
    # Delete duplicates (multiple instances of the same match when there are multiple scorers)
    for_deleting = []
    for i in range(len(final)) :
        if((i != 0) and (final[i][3] == final[i-1][3])) :
            for_deleting.append(final[i])
            if(final[i-1] in for_deleting) :
                if(final[i-2] in for_deleting) :
                    final[i-3][9].append(final[i][9][0])
                else :
                    final[i-2][9].append(final[i][9][0])
            else :
                final[i-1][9].append(final[i][9][0])
    
    final = [f for f in final if f not in for_deleting]
    
    
    # Export to JSON
    attributes = ["club", "city", "country", "year", "final_stadium", "head_coach", "captain", "final_match-up", "result", "scorers", "final_attendance"]
    attributes_coach = ["name", "country"]
    attributes_player = ["name", "country", "position"]
    to_json = []
    for f in final :
        f[5] = dict(zip(attributes_coach, f[5]))
        f[6] = dict(zip(attributes_player, f[6]))
        for i in range(len(f[9])) :
            f[9][i] = dict(zip(attributes_player, f[9][i]))
        to_json.append(dict(zip(attributes, tuple(f))))
    
    json_object = json.dumps(to_json, indent=4)
    with open("ucl_winners.json", "w") as outfile:
        outfile.write(json_object)
        
    return "hello"
if __name__ == '__main__':
    app.run(port = 5000)