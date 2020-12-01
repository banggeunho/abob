class MenuINFO
{
	private String str_id;
	private String name;
	private String str_name;
	private int cost;
	private int food_time;
	


	public MenuINFO(String str_id, String name, String str_name, int cost, int food_time){
		this.str_id=str_id;
		this.name=name;
		this.str_name=str_name;
		this.cost=cost;
		this.food_time=food_time;
	}
	public String getId(){
		return str_id;
	}
	public String getName(){
		return name;
	}
	public String getStrName(){
		return str_name;
	}
	public int getCost(){
		return cost;
	}
	public int getTime(){
		return food_time;
	}
}
