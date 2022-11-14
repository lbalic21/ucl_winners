export type Player = {
    id: number;
    name: string;
    country: string;
    position: string;
};

export type Coach = {
    id: number;
    name: string;
    country: string;
};

export type UclWinner = {
    id: number;
    club: string;
    city: string;
    country: string;
    year: number;
    finalStadium: string;
    headCoach: Coach;
    Captain: Player;
    finalMatchup: string;
    result: string;
    scorers: Player[];
    finalAttendance: number;
};