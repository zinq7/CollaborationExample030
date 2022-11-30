import java.util.File;
import java.swing.*;
public class DisplayPhoto {
  // file path:
  final String FILE_PATH = "win.png";
  
  // main
  public static void main(String[] args) {
    // create frame
    File imgFile = new File(FILE_PATH);
    JFrame frame = new JFrame(200, 200);
    JImage image = new Image(imgFile);
    frameAddImages(frame, image);

    // show
    frame.setVisible(true);
  }
  
  // add 5x5 images pattern
  public static void frameAddImages(JFrame frame, JImage img) {
    for (int i = 0; i < frame.width / 5; i++) {
      for (int k = 0; k < frame.height / 5; k++) {
        frame.add(img, i * frame.width / 5, k * frame.height / 5);
      }
    }
  }
  
  // ISSUE: FileNotFoundException! (also code doesn't work)
}
    
