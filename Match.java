
/**
 * Write a description of class match here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Match
{
    // instance variables - replace the example below with your own
    private String homeTeamName;
    private String awayTeamName;
    private int homeGoals;
    private int awayGoals;

    
    public Match(String homeName, String awayName, int homeGoals, int awayGoals )
    {
        homeTeamName = homeName;
        awayTeamName = awayName;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    public String getHomeTeamName() 
    { return homeTeamName;
    }
    public String getAwayTeamName() 
    { return awayTeamName;
    }
    public int getHomeGoals()
    { return homeGoals;
    }
    public int getAwayGoals()
    {return awayGoals;
    }
}
