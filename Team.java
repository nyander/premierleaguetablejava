
/**
 * Write a description of class Team here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Team implements Comparable <Team>
{
  private String shortName;
  private String longName;
  private int played;
  private int goalsFor;
  private int goalsAgainst;
  private int won;
  private int drawn;
  private int lost;
  private int points;
  
    public Team(String longName, String shortName)
    {
        this.shortName = shortName;
        this.longName =  longName;
        played = 0;
        goalsFor = 0;
        goalsAgainst = 0;
        won = 0;
        drawn = 0;
        lost = 0;
        points = 0;
    }
    public String getTeamName()
    { return longName;
    }
    public String getShortName()
    { return shortName;
    }
    public int getPlayed()
    {return played;
    }
     public int getGoalsFor()
    {return goalsFor;
    }
     public int getGoalsAgainst()
    {return goalsAgainst;
    }
     public int getWon()
    {return won;
    }
     public int getDrawn()
    {return drawn;
    }
     public int getLost()
    {return lost;
    }
     public int getPoints()
    {return points;
    }
    public int getGoalDifference()
    {
        return goalsAgainst - goalsFor;
    }
    public void play(Match match)
    { played++; // it is the same as saying played = played plusn 1
        int goalsForThisMatch = 0;
        int goalsAgainstThisMatch = 0;
      
        if (shortName.equals(match.getHomeTeamName()))
        {
            goalsForThisMatch = match.getHomeGoals();
            goalsAgainstThisMatch = match.getAwayGoals();
        }
        else if(shortName.equals(match.getAwayTeamName()))
        {
            goalsForThisMatch = match.getAwayGoals();
            goalsAgainstThisMatch = match.getHomeGoals();
        }
        goalsFor += goalsForThisMatch;
        goalsAgainst += goalsAgainstThisMatch;
        if (goalsFor == goalsAgainst)
        {drawn++; // drawn= drawn + 1 
        }
        else if (goalsFor > goalsAgainst)
        {won++;}
        else if (goalsFor < goalsAgainst)
        { lost++; }
        points = won*3+drawn;
    }
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append (String.format ("%-25s", longName));
        sb.append (getPlayed ());
        sb.append ("\t");
        sb.append (won);
        sb.append ("\t");
        sb.append (drawn);
        sb.append ("\t");
        sb.append (lost);
        sb.append ("\t");
        sb.append (goalsFor);
        sb.append ("\t");
        sb.append (goalsAgainst);
        sb.append ("\t");
        if ((goalsAgainst - goalsFor) > 0) {
            sb.append("+");
        }
        
        sb.append (goalsAgainst - goalsFor);
        sb.append ("\t");
        sb.append (points);
        return sb.toString();
    }
    public int compareTo (Team t) {
        int diff = t.getPoints() - getPoints();
        if (diff != 0) {
            return diff;
        }
        else{
            return getGoalsFor() - t.getGoalsFor() ;
        }

    }
}
        
   
    