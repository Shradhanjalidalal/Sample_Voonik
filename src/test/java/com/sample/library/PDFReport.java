package com.sample.library;


import java.io.FileOutputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFReport 
{
  public static void report() throws Exception
  {
    Document document=new Document();
    PdfWriter.getInstance(document,new FileOutputStream("D:/sample.pdf"));
    document.open();
    document.add(new Paragraph("failed testcase:1"));
    document.add(new Paragraph("Id not found"));
    document.close();
  }
  public static void main(String[] args) throws Exception 
  {
	WebDriver driver=new FirefoxDriver();
	driver.get("http://www.google.com");
	
	try{
		driver.findElement(By.id("Bing"));
	}
	catch(Exception e)
	{
		report();
		System.out.println("Error found in id");
	}
  }
}
