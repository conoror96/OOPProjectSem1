package ie.gmit.sw;

public class Shingle {
	private int documentId;
	private int shingleHashCode;
	public Shingle(int documentId, int shingleHashCode){
		this.documentId = documentId;
		this.shingleHashCode = shingleHashCode;
	}
}
//getters/setters
//override gasgCode + equals using the shingleHashCode