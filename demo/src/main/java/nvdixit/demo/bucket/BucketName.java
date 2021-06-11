package nvdixit.demo.bucket;

public enum BucketName {
	TRANSACTION("nvdixit-demo-bucket");
	
	private final String bucketName;
	
	BucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	
	public String getBucketName() {
		return this.bucketName;
	}
}
