package deathbattle;

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
	
	@Override
	public int compareTo(ScheduleObject sobj) {
		
		 int difference = this.getStartTime() - sobj.getStartTime();
		 
		 return difference;
	}
	
	
	

}
