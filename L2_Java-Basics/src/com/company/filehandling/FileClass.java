package com.company.filehandling;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileClass {

    // Read and Write from file

    public static void main(String[] args) throws IOException {
//        writeToFile();
//        readAFile();
        downloadImage();
    }

    public static void writeToFile() throws IOException {

        Scanner scanner = new Scanner(System.in);

        String text;

        FileOutputStream fileOutputStream = new FileOutputStream("sample.txt", true);
        do{
            text = scanner.next() + "\n";
            fileOutputStream.write(text.getBytes(StandardCharsets.UTF_8));

//            for(int i = 0; i < text.length(); i++){
//                fileOutputStream.write(text.charAt(i));
//            }

        }while(!text.equals("end"));

        fileOutputStream.close();

    }

    public static void readAFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("sample.txt"));

        String str;
        while((str = bufferedReader.readLine()) != null){
            System.out.println(str);
        }

    }

    public static void downloadImage() throws IOException {
        URL url = new URL("https://picsum.photos/id/1041/200/300");
        InputStream inputStream = new BufferedInputStream(url.openStream());

        FileOutputStream fileOutputStream = new FileOutputStream("image.png");

        byte[] data = new byte[1024];
        while(inputStream.read(data) != -1){
            fileOutputStream.write(data);
        }

        fileOutputStream.close();
        inputStream.close();
    }
}
