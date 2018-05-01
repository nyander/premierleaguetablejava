/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author beaumoaj
 */
public class League {
    private HashMap<String, Team> teams;
    private ArrayList<Team> teamList;

    /**
     * @param args the command line arguments
     */
    public League() {
        try {
            // TODO code application logic here
            teams = new HashMap<>();
            teamList = new ArrayList<>();
            
            File teamFile = new File("PLTeams.csv");
            File matchFile = new File("PLMatches.csv");
            Scanner sTeam = new Scanner(teamFile);
            Scanner sMatch = new Scanner(matchFile);
            sTeam.nextLine();
            while (sTeam.hasNext()) {
                String teamLine = sTeam.nextLine();
                Team t = createTeam(teamLine);
                teams.put(t.getShortName().toLowerCase().trim(), t);
                teamList.add(t);
            }
            sMatch.nextLine();
            while (sMatch.hasNext()) {
                String matchLine = sMatch.nextLine();
                Match match = createMatch(matchLine);
                Team home  = teams.get(match.getHomeTeamName().toLowerCase().trim());
                Team away = teams.get(match.getAwayTeamName().toLowerCase().trim());
                if (home != null && away != null) {
                    home.play(match);
                away.play(match);
                } else {
                    Logger.getLogger(League.class.getName()).log(Level.SEVERE, "Home:"+match.getHomeTeamName());
                    Logger.getLogger(League.class.getName()).log(Level.SEVERE, "Away:"+match.getAwayTeamName());
                }
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(League.class.getName()).log(Level.SEVERE, "I can't find one of the input files.  Please check the location is correct", ex);
            System.exit(1);
        }
        
    }
    
    private Team createTeam(String teamInput) {
        //  Team,FDCOUK,City,Stadium,Capacity,Latitude,Longitude,Country
        String[] fields = teamInput.split(",");
        String teamName = fields[0];
        String shortName = fields[1];
        //String stadiumName = fields[3];
        //int capacity = Integer.parseInt(fields[4]);
        //double lat = Double.parseDouble(fields[5]);
        //double lon = Double.parseDouble(fields[6]);
        //Stadium stadium = new Stadium(stadiumName,capacity,lat,lon);
        Team team = new Team(teamName, shortName);
        return team;
    }
    
    private Match createMatch(String matchInput) {
        // Div,Date,HomeTeam,AwayTeam,FTHG,FTAG,FTR,HTHG,HTAG,HTR,Referee,HS,AS,HST,AST,HF,AF,HC,AC,HY,AY,HR,AR,B365H,B365D,B365A,BWH,BWD,BWA,IWH,IWD,IWA,LBH,LBD,LBA,PSH,PSD,PSA,WHH,WHD,WHA,VCH,VCD,VCA,Bb1X2,BbMxH,BbAvH,BbMxD,BbAvD,BbMxA,BbAvA,BbOU,BbMx>2.5,BbAv>2.5,BbMx<2.5,BbAv<2.5,BbAH,BbAHh,BbMxAHH,BbAvAHH,BbMxAHA,BbAvAHA,PSCH,PSCD,PSCA
        String[] fields = matchInput.split(",");
        String home = fields[2];
        String away = fields[3];
        int homeGoals = Integer.parseInt(fields[4]);
        int awayGoals = Integer.parseInt(fields[5]);
        return new Match(home, away, homeGoals, awayGoals);
    }
    
    private List<Team> getTeams() {
        return teamList;
    }
    
    private Team getTeam(String teamName) {
        return teams.get(teamName);
    }
    
    public void printLeague() {
        Collections.sort(getTeams());
        for (Team t : teamList) {
            System.out.println(t);
        }
    }
    
    public static void main(String[] args) {
        League l = new League();       
        l.printLeague();
    }
}
