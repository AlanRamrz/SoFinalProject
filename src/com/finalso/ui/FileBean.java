package com.finalso.ui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.primefaces.event.FileUploadEvent;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Named
@RequestScoped
public class FileBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 156906261816649166L;
	private static final String clientRegion = Region.getRegion(Regions.US_EAST_2).toString();
	private static final String access = "";
	private static final String secret = "";

	public FileBean() {
		System.out.println("Constructor de File Bean");
	}
	
	public void subirArchivo(FileUploadEvent e) throws IOException{
		System.out.println("Comenzando a subir el archivo...");
		
		String ruta="/home/ubuntu/FilesMlb/";
		//String ruta="/Users/alanramirez/Documents/";
		InputStream in=e.getFile().getInputstream();
		File file= new File(ruta+e.getFile().getFileName());
		OutputStream out = new FileOutputStream(file);
		
		IOUtils.copy(in, out);
		in.close();
		out.close();
		
		System.out.println("Terminando de subir el archivo.");
		
		uploadFileToAwsBucket(file);
	}
	
	public void uploadFileToAwsBucket(File archivo) {
		System.out.println("Comenzando a subir el archivo al bucket de Awss...");
		
		try {
			BasicAWSCredentials credentials = new BasicAWSCredentials(access, secret);
			//AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(new ProfileCredentialsProvider()).withRegion(clientRegion).build();
			AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(clientRegion).build();

			
			PutObjectRequest request = new PutObjectRequest("lambda-bucket-uia-scores", archivo.getName(), archivo);
			ObjectMetadata metadata = new ObjectMetadata();
			
            metadata.setContentType("plain/text");
            metadata.addUserMetadata("x-amz-meta-title", "someTitle");
            request.setMetadata(metadata);
			s3Client.putObject(request);
			
			System.out.println("Se ha subido el archivo al bucket.");
			
			archivo.delete();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
