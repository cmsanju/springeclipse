package com.test;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;

public class HelloTest {
	
	public static void main(String[] args) {
		String bucket_name = "hellosanju";
		String secretKey = "AKIAXK3XNNIQ4HAEG5EX";
		String accessKey = "h4xmXwlrOESHXS5VXLSgdPi9CgdNmY+uzcYLzfVM";
		String AWSRegion = "ap-south-1";

		BasicAWSCredentials basicCredentials = new BasicAWSCredentials(secretKey,accessKey);
		AmazonS3 s3 = AmazonS3Client.builder()
		.withCredentials(new StaticCredentialsProvider(basicCredentials))
		.withRegion(AWSRegion)
		.build();

		Bucket bucket = null;
		try {
		bucket = s3.createBucket(bucket_name);
		} catch (AmazonS3Exception e) {
		System.err.println(e.getErrorMessage());
		}

		if (bucket == null)
		System.out.println("Error creating bucket!\n");
		else
		System.out.println("Bucket Created!\n");

		}

}
