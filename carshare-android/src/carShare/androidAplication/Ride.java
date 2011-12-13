package carShare.androidAplication;

public class Ride {
	
	private String departureTime;
	private String timeOfArrival;
	private String pricePerPerson;
	private String totalPrice;
	private String freePlace;
	private String driverEvaluation;
	private String detail;
	
	public Ride(String _departureTime, String _timeOfArrival, String _pricePerPerson, String _totalPrice, String _freePlace, String _driverEvaluation, String _detail)
	{
		departureTime = _departureTime;
		timeOfArrival = _timeOfArrival;
		pricePerPerson = _pricePerPerson;
		totalPrice = _totalPrice;
		freePlace = _freePlace;
		driverEvaluation = _driverEvaluation;
		detail = _detail;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getTimeOfArrival() {
		return timeOfArrival;
	}

	public void setTimeOfArrival(String timeOfArrival) {
		this.timeOfArrival = timeOfArrival;
	}

	public String getPricePerPerson() {
		return pricePerPerson;
	}

	public void setPricePerPerson(String pricePerPerson) {
		this.pricePerPerson = pricePerPerson;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getFreePlace() {
		return freePlace;
	}

	public void setFreePlace(String freePlace) {
		this.freePlace = freePlace;
	}

	public String getDriverEvaluation() {
		return driverEvaluation;
	}

	public void setDriverEvaluation(String driverEvaluation) {
		this.driverEvaluation = driverEvaluation;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
