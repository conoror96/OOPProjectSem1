package ie.gmit.sw;

public class Shingle {
	private int documentId;
	private int shingleHashCode;

	public Shingle(int documentId, int shingleHashCode) {
		this.documentId = documentId;
		this.shingleHashCode = shingleHashCode;
	}

	// getters/setters
	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public int getShingleHashCode() {
		return shingleHashCode;
	}

	public void setShingleHashCode(int shingleHashCode) {
		this.shingleHashCode = shingleHashCode;
	}
	// override gasgCode + equals using the shingleHashCode

}