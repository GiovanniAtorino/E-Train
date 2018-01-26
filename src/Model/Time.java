package Model;

public class Time {
	
	public String CalcTime(long startTime, long endTime)
	{
	    String time = "";

	    long seconds = (endTime/1000) - (startTime/1000);

	    if(seconds>0 && seconds<=59)
	    {
	        if(seconds==1)
	            time = "1 secondo";
	        else
	            time = seconds + " secondi";
	    }
	    else
	        if(seconds>=60 && seconds<=3599)
	        {
	            long minute = seconds / 60;
	            if(minute==1)
	                time = "1 minuto";
	            else
	               if(minute>1)
	                   time = minute + " minuti ";
	        }
	        else
	            if(seconds>=3600 && seconds<=86399)
	            {
	                long hour = seconds / 3600;
	                long minute = (seconds / 60) - (hour * 60);

	                if(hour==1)
	                {
	                    if(minute>0)
	                        time="1 ora e " + minute + " minuti";
	                    else
	                        time="1 ora";
	                }
	                else
	                if(hour>1)
	                {	
	                	if(minute>0)
	                		time = hour + " ore e " + minute + " minuti";
	                	else
	                		time = hour + " ore";
	                }
	            }
	    return time;
	}
	
	public long CalcHour(long startTime, long endTime)
	{
	    long hour = 0;

	    long seconds = (endTime/1000) - (startTime/1000);

	    if(seconds>=3600 && seconds<=86399)
	    {
 	      hour = seconds / 3600;
	    }
	    
	    return hour;
	}
	
	public long CalcMinute(long startTime, long endTime, long hour)
	{
	    long minute = 0;

	    long seconds = (endTime/1000) - (startTime/1000);
	    
	    if(seconds>=60 && seconds<=86399)
        {
	    	minute = (seconds / 60) - (hour * 60);         
        }
	    
	    return minute;
	}
}
