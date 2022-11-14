package fer.or.ucl_winners.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UclWinner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;
    private String club;
    private String city;
    private String country;
    private Integer year;
    private String finalStadium;
    @ManyToOne
    @JoinColumn(name="head_coach")
    private Coach headCoach;
    @ManyToOne
    @JoinColumn(name="captain")
    private Player captain;
    private String finalMatchup;
    private String result;
    @ManyToMany
    @JoinTable(
    name = "ucl_winner_player", 
    joinColumns = @JoinColumn(name = "ucl_winner_id"), 
    inverseJoinColumns = @JoinColumn(name = "player_id"))
    private List<Player> scorers;
    private Integer finalAttendance;

    @Override
    public String toString() {
        String s = "";
        for (Player player: scorers) {
            s += player.getName() + " ";
        }
        return String.format("%s %s %s %s %s %s %s %s %s %s %s",club, city, country, year, finalStadium, headCoach.getName(), captain.getName(), finalMatchup, result, finalAttendance, s);
    }
    
}