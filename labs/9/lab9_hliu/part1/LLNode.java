public class LLNode<Employee>{
	protected Employee info;
	protected LLNode<Employee> link;

	public LLNode(Employee info){
		this.info = info;
		link = null;
	}

	public void setInfo(Employee info){
		this.info = info;
	}
	
	public Employee getInfo(){
		return info;
	}
	
	public void setLink(LLNode<Employee> link){
		this.link = link;
	}
	
	public LLNode<Employee> getLink(){
		return link;
	}
}
