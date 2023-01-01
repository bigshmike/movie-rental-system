package edu.wccnet.mbrown99.finProj.api;

public class MovieNotFoundErrorResponse {
	private int status;
	private String msg;
	private long timeStamp;
	
	public MovieNotFoundErrorResponse() {
		
	}

	public MovieNotFoundErrorResponse(int status, String msg, long timeStamp) {
		setStatus(status);
		setMsg(msg);
		setTimeStamp(timeStamp);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "MovieNotFoundErrorResponse [status=" + status + ", msg=" + msg + ", timeStamp=" + timeStamp + "]";
	}
	
	

}
