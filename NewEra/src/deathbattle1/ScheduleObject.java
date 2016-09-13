package deathbattle1;

public class ScheduleObject implements Comparable<ScheduleObject>{ // comparable you need to specify the obj type
	private String contentId;
	private String areaId;
	private int startTime;
	private int endTime;

	public String getContentId() {
		return contentId;
	}
	
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	
	public String getAreaId() {
		return areaId;
	}
	
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	
	public int getEndTime() {
		return endTime;
	}
	
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
	public ScheduleObject withContentId(String contentId) {
	    this.contentId = contentId;
	    return this;
	}
	
	public ScheduleObject withAreaId(String areaId) {
	    this.areaId = areaId;
	    return this;
	}
	
	public ScheduleObject withStartTime(int startTime) {
	    this.startTime = startTime;
	    return this;
	}
	
	public ScheduleObject withEndTime(int endTime) {
	    this.endTime = endTime;
	    return this;
	}
	public boolean overlap(ScheduleObject another) {
	    if (startTime > another.endTime || endTime < another.startTime) {
	        return false;
	    }
	    return true;
	}
	
	@Override
	public int compareTo(ScheduleObject sobj) {
		
		 int difference = this.getStartTime() - sobj.getStartTime();
		 
		 return difference;
	}
	
	@Override
	public String toString() {
	    return contentId + " " + areaId + " " + startTime + " " + endTime;
	}
}
