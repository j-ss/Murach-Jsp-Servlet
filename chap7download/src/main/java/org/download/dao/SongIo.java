package org.download.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SongIo { public BufferedReader getProduct(){
  Path path= Paths.get("/home/patel/jogi/projects/murach/chapter7download/src/main/resources/music.txt");
  BufferedReader reader=null;
  try {
    reader= Files.newBufferedReader(path);
  } catch (IOException e) {
    e.printStackTrace();
  }
  return reader;
}

}
