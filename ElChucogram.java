/* CS1101 – Intro to Computer Science
Instructor: Logan
Comprehensive Lab 2
By including my name below, I confirm that:
-	I am submitting my original work.
-	If I include code obtained from another source or I received help I am giving attribution to those sources as comments.
-	This submission does not incur in any academic dishonesty practice as described in the course syllabus.
Modified and submitted by: Janeth Meraz
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException; // Added.
import java.io.FileWriter; // Added.
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner; // Added.
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ElChucogram {

  // *-*-*-*-*-*-*-*-*-*-*-*-
  // Ignore this part
  // *-*-*-*-*-*-*-*-*-*-*-*-
  private static JLabel imageLabel = null;
  private static JFrame frame = null;
  private static Color[][] workingImage = null;
  private static ArrayList<Integer> mouseClicks = new ArrayList<Integer>();
  private static int normFactor = 50;
  private static JButton recordButton = null;
  private static boolean recording = false;
  private static String recordingFileName = null;

  private enum Effect {
    LIQUIFY,
    TWIST_LEFT,
    TWIST_RIGHT,
    PINCH,
    BULGE;
  }

  private static Effect currentEffect = Effect.LIQUIFY;
  // *-*-*-*-*-*-*-*-*-*-*-*-
  // Ignore this part
  // *-*-*-*-*-*-*-*-*-*-*-*-

  public static void main(String[] args) throws Exception {
    displayApp();
  }

  /** TODO: Implement and document this method */
  public static void liquifyEffect(
      Color[][] imagePixels, int rowP0, int colP0, int rowP1, int colP1, double normFactor) {
    Color[][] destination = new Color[imagePixels.length][imagePixels[0].length];

    // Add your code here

    // Find the difference between the first and second click.
    double deltaRow = rowP1 - rowP0;
    double deltaCol = colP1 - colP0;

    // Iterate through the destination image.
    for (int destRow = 0; destRow < destination.length; destRow++) {
      for (int destCol = 0; destCol < destination[0].length; destCol++) {
        // Find the eucledian distance between the second click index and the destination index.
        double distance = Math.sqrt(Math.pow(destRow - rowP1, 2) + Math.pow(destCol - colP1, 2));
        // Calculate the warping effect of each point.
        double weight = Math.pow(2, -distance / normFactor);
        // Convert to integer values because they are the indices of the array.
        int srcRow = (int) (destRow - deltaRow * weight);
        int srcCol = (int) (destCol - deltaCol * weight);

        // Make sure it does not go out of bounds of the array.
        // Values cannot be less than 0 or greater than the size of the array.
        if (srcRow < 0) {
          srcRow = 0;
        }
        if (srcCol < 0) {
          srcCol = 0;
        }
        if (srcRow >= imagePixels.length) {
          srcRow = imagePixels.length - 1;
        }
        if (srcCol >= imagePixels[0].length) {
          srcCol = imagePixels[0].length - 1;
        }
        // Assign the pixel values from the orginal image to the new image.
        destination[destRow][destCol] = imagePixels[srcRow][srcCol];
      }
    }
    // Update the image on the screen.
    updateImage(destination);
  }

  /** TODO: Implement and document this method */
  public static void twistLeftEffect(
      Color[][] imagePixels, int rowP0, int colP0, double normFactor) {
    Color[][] destination = new Color[imagePixels.length][imagePixels[0].length];

    // Add your code Here
    double maxAngleDelta = Math.PI / 2;

    // Iterate through the destination image.
    for (int destRow = 0; destRow < destination.length; destRow++) {
      for (int destCol = 0; destCol < destination[0].length; destCol++) {
        // Find the eucledian distance between the chosen point and the destination index.
        double distance = Math.sqrt(Math.pow(destRow - rowP0, 2) + Math.pow(destCol - colP0, 2));
        // Calculate the warping effect of each point.
        double weight = Math.pow(2, -distance / normFactor);
        double angleDelta = maxAngleDelta * weight;
        double newAngle = Math.atan2(destRow - rowP0, destCol - colP0) + angleDelta;
        // Convert to integer values because they are the indices of the array.
        int srcRow = (int) (rowP0 + Math.sin(newAngle) * distance);
        int srcCol = (int) (colP0 + Math.cos(newAngle) * distance);

        // Make sure it does not go out of bounds of the array.
        // Values cannot be less than 0 or greater than the size of the array.
        if (srcRow < 0) {
          srcRow = 0;
        }
        if (srcCol < 0) {
          srcCol = 0;
        }
        if (srcRow >= imagePixels.length) {
          srcRow = imagePixels.length - 1;
        }
        if (srcCol >= imagePixels[0].length) {
          srcCol = imagePixels[0].length - 1;
        }
        // Assign the pixel values from the orginal image to the new image.
        destination[destRow][destCol] = imagePixels[srcRow][srcCol];
      }
    }
    // Update the image on the screen.
    updateImage(destination);
  }

  /** TODO: Implement and document this method */
  public static void twistRightEffect(
      Color[][] imagePixels, int rowP0, int colP0, double normFactor) {
    Color[][] destination = new Color[imagePixels.length][imagePixels[0].length];

    // Add your code here
    double maxAngleDelta = -Math.PI / 2;

    // Iterate through the destination image.
    for (int destRow = 0; destRow < destination.length; destRow++) {
      for (int destCol = 0; destCol < destination[0].length; destCol++) {
        // Find the eucledian distance between the chosen point and the destination index.
        double distance = Math.sqrt(Math.pow(destRow - rowP0, 2) + Math.pow(destCol - colP0, 2));
        // Calculate the warping effect of each point.
        double weight = Math.pow(2, -distance / normFactor);
        double angleDelta = maxAngleDelta * weight;
        double newAngle = Math.atan2(destRow - rowP0, destCol - colP0) + angleDelta;
        // Convert to integer values because they are the indices of the array.
        int srcRow = (int) (rowP0 + Math.sin(newAngle) * distance);
        int srcCol = (int) (colP0 + Math.cos(newAngle) * distance);

        // Make sure it does not go out of bounds of the array.
        // Values cannot be less than 0 or greater than the size of the array.
        if (srcRow < 0) {
          srcRow = 0;
        }
        if (srcCol < 0) {
          srcCol = 0;
        }
        if (srcRow >= imagePixels.length) {
          srcRow = imagePixels.length - 1;
        }
        if (srcCol >= imagePixels[0].length) {
          srcCol = imagePixels[0].length - 1;
        }
        // Assign the pixel values from the orginal image to the new image.
        destination[destRow][destCol] = imagePixels[srcRow][srcCol];
      }
    }
    // Update the image on the screen.
    updateImage(destination);
  }

  /** TODO: Implement and document this method */
  public static void pinchEffect(Color[][] imagePixels, int rowP0, int colP0, double normFactor) {
    Color[][] destination = new Color[imagePixels.length][imagePixels[0].length];

    // Add your code here
    double maxDistDelta = -0.5;

    // Iterate through the destination image.
    for (int destRow = 0; destRow < destination.length; destRow++) {
      for (int destCol = 0; destCol < destination[0].length; destCol++) {
        // Find the eucledian distance between the chosen point and the destination index.
        double distance = Math.sqrt(Math.pow(destRow - rowP0, 2) + Math.pow(destCol - colP0, 2));
        // Calculate the warping effect of each point.
        double weight = Math.pow(2, -distance / normFactor);
        double angle = Math.atan2(destRow - rowP0, destCol - colP0);
        double deltaDistance = maxDistDelta * distance;
        double weightedDistance = distance - weight * deltaDistance;
        // Convert to integer values because they are the indices of the array.
        int srcRow = (int) (rowP0 + Math.sin(angle) * weightedDistance);
        int srcCol = (int) (colP0 + Math.cos(angle) * weightedDistance);

        // Make sure it does not go out of bounds of the array.
        // Values cannot be less than 0 or greater than the size of the array.
        if (srcRow < 0) {
          srcRow = 0;
        }
        if (srcCol < 0) {
          srcCol = 0;
        }
        if (srcRow >= imagePixels.length) {
          srcRow = imagePixels.length - 1;
        }
        if (srcCol >= imagePixels[0].length) {
          srcCol = imagePixels[0].length - 1;
        }
        // Assign the pixel values from the orginal image to the new image.
        destination[destRow][destCol] = imagePixels[srcRow][srcCol];
      }
    }
    // Update the image on the screen.
    updateImage(destination);
  }

  /** TODO: Implement and document this method */
  public static void bulgeEffect(Color[][] imagePixels, int rowP0, int colP0, double normFactor) {
    Color[][] destination = new Color[imagePixels.length][imagePixels[0].length];

    // Add your code here
    double maxDistDelta = 0.5;

    // Iterate through the destination image.
    for (int destRow = 0; destRow < destination.length; destRow++) {
      for (int destCol = 0; destCol < destination[0].length; destCol++) {
        // Find the eucledian distance between the chosen point and the destination index.
        double distance = Math.sqrt(Math.pow(destRow - rowP0, 2) + Math.pow(destCol - colP0, 2));
        // Calculate the warping effect of each point.
        double weight = Math.pow(2, -distance / normFactor);
        double angle = Math.atan2(destRow - rowP0, destCol - colP0);
        double deltaDistance = maxDistDelta * distance;
        double weightedDistance = distance - weight * deltaDistance;
        // Convert to integer values because they are the indices of the array.
        int srcRow = (int) (rowP0 + Math.sin(angle) * weightedDistance);
        int srcCol = (int) (colP0 + Math.cos(angle) * weightedDistance);

        // Make sure it does not go out of bounds of the array.
        // Values cannot be less than 0 or greater than the size of the array.
        if (srcRow < 0) {
          srcRow = 0;
        }
        if (srcCol < 0) {
          srcCol = 0;
        }
        if (srcRow >= imagePixels.length) {
          srcRow = imagePixels.length - 1;
        }
        if (srcCol >= imagePixels[0].length) {
          srcCol = imagePixels[0].length - 1;
        }
        // Assign the pixel values from the orginal image to the new image.
        destination[destRow][destCol] = imagePixels[srcRow][srcCol];
      }
    }
    // Update the image on the screen.
    updateImage(destination);
  }

  /**
   * Executes the operations stored in the given text file
   *
   * @param filePath Path to the file that contains the instructions
   */
  private static void executeFileInstructions(String filePath) {
    // Add your code here

    File fileName;
    Scanner reading;
    // Check if the file path exists.
    try {
      fileName = new File(filePath);
      reading = new Scanner(fileName);
    } catch (FileNotFoundException e) {
      // If file is not found, print an error message.
      System.out.println("The file does not exist. Exiting.");
      return;
    }
    // Initialize the variables for the effect type and the indexes.
    String effect;
    int x1 = 0;
    int y1 = 0;
    int x2 = 0;
    int y2 = 0;

    // Read the file.
    while (reading.hasNext()) {
      // Set the first word in the file as the effect type.
      effect = reading.next();
      while (reading.hasNextInt()) {
        // Set the next two integers as the X and Y coordinates.
        x1 = reading.nextInt();
        y1 = reading.nextInt();
        if (reading.hasNextInt()) {
          // If there are more integers after those two, set those as additional X and Y
          // coordinates.
          x2 = reading.nextInt();
          y2 = reading.nextInt();
        }
      }

      // If the effect name is liquify, then call the method liquify with the coordinates and norm
      // factor.
      if (effect.contains("LIQUIFY")) {
        liquifyEffect(workingImage, x1, y1, x2, y2, normFactor);
      }
      // If the effect name is twist left, then call the method liquify with the coordinates and
      // norm
      // factor.
      if (effect.contains("TWIST_LEFT")) {
        twistLeftEffect(workingImage, x1, y1, normFactor);
      }
      // If the effect name is twist right, then call the method liquify with the coordinates and
      // norm
      // factor.
      if (effect.contains("TWIST_RIGHT")) {
        twistRightEffect(workingImage, x1, y1, normFactor);
      }
      // If the effect name is pinch, then call the method liquify with the coordinates and norm
      // factor.
      if (effect.contains("PINCH")) {
        pinchEffect(workingImage, x1, y1, normFactor);
      }
      // If the effect name is bluge, then call the method liquify with the coordinates and norm
      // factor.
      if (effect.contains("BULGE")) {
        bulgeEffect(workingImage, x1, y1, normFactor);
      }
    }
  }

  /**
   * Appends the given effect to the given text file
   *
   * @param filePath Path to the text file
   * @param effectName One of the following: LIQUIFY, TWIST_LEFT, TWIST_RIGHT, PINCH, BULGE
   * @param effectParams Effect parameters
   */
  private static void appendOperationToFile(
      String filePath, String effectName, int[] effectParams) {
    // Add your code here
    FileWriter fileWriter;
    try {
      // Set the file writer to write in the file path and always be true for the boolean append.
      // Does not overwrite existing information on the file.
      fileWriter = new FileWriter(filePath, true);
      // Write the effect name first.
      fileWriter.write(effectName + " ");

      // Iterate through the effect parameters array to write all of its contents.
      for (int i = 0; i < effectParams.length; i++) {
        fileWriter.write(effectParams[i] + " ");
      }
      // End with a new line.
      fileWriter.write("\n");

      // Close the write.
      fileWriter.close();
    } catch (IOException e) {
      // If there was an exception, exit the program.
      System.out.println("IOException. Exiting.");
      return;
    }
  }

  /**
   * Extra Credit: Save the image that is being displayed. Hint: the global variable workingImage
   * holds the pixel values of the image that needs to be saved
   */
  protected static void saveImageClicked() {
    // JOptionPane.showMessageDialog(frame, "Extra Credit: Implement this feature");
    // Add your code here

    // I used existing code on this file to create a way for the user to input the file they want
    // saved.
    String saveImageName = JOptionPane.showInputDialog(frame, "Type the name of a png file");

    try {
      // Convert to BufferedImage
      BufferedImage bi = createImageFromPixelArray(imagePixels);

      // Save file
      File outputfile = new File(saveImageName);
      ImageIO.write(bi, "jpg", outputfile);
    } catch (IOException e) {
      System.out.println("Error: " + e.toString());
    }
  }

  // *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
  //
  // You can ignore the rest of this file. You don't have to understand what these methods do.
  // However, if you are curious, feel free to read them! (:
  //
  // *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

  /**
   * Updates the image being displayed
   *
   * @param imagePixels New image to be displayed
   */
  public static void updateImage(Color[][] imagePixels) {
    workingImage = imagePixels;
    mouseClicks.clear();
    frame.remove(imageLabel);
    BufferedImage image = createImageFromPixelArray(imagePixels);
    ImageIcon icon = new ImageIcon();
    icon.setImage(image);

    imageLabel = new JLabel();
    imageLabel.setIcon(icon);

    imageLabel.addMouseListener(
        new MouseListener() {
          public void mousePressed(MouseEvent me) {}

          public void mouseReleased(MouseEvent me) {}

          public void mouseEntered(MouseEvent me) {}

          public void mouseExited(MouseEvent me) {}

          public void mouseClicked(MouseEvent me) {
            if (me.getButton() == MouseEvent.BUTTON1) {
              imageClicked(me.getY(), me.getX());
            }
          }
        });

    frame.add(imageLabel);
    frame.invalidate();
    frame.revalidate();
    frame.repaint();
  }

  /**
   * Computes Euclidean distance of the two given points
   *
   * @param rowP0
   * @param colP0
   * @param rowP1
   * @param colP1
   * @return
   */
  public static double computeDistance(int rowP0, int colP0, int rowP1, int colP1) {
    return Math.sqrt(Math.pow(rowP1 - rowP0, 2) + Math.pow(colP1 - colP0, 2));
  }

  /** Executes when the Record/Stop button is clicked. */
  public static void recordClicked() {

    if (!recording)
      recordingFileName = JOptionPane.showInputDialog(frame, "Type the name of the file");

    recording = !recording;

    recordButton.setText(recording ? "Stop" : "Record");
  }

  /**
   * This method saves a given image to disk
   *
   * @param imagePixels Image to be saved
   * @param fileName Name of the file
   */
  public static void saveImage(Color[][] imagePixels, String fileName) {
    try {
      // Convert to BufferedImage
      BufferedImage bi = createImageFromPixelArray(imagePixels);

      // Save file
      File outputfile = new File(fileName);
      ImageIO.write(bi, "jpg", outputfile);
    } catch (IOException e) {
      System.out.println("Error: " + e.toString());
    }
  }

  /**
   * Executes a given effect when the image is clicked
   *
   * @param row row where the image was clicked
   * @param col col where the image was clicked
   */
  private static void imageClicked(int row, int col) {

    int[] params = {row, col};
    switch (currentEffect) {
      case LIQUIFY:
        if (mouseClicks.size() < 2) {
          mouseClicks.add(row);
          mouseClicks.add(col);
        } else {

          int[] liquifyParams = {mouseClicks.get(0), mouseClicks.get(1), row, col};
          liquifyEffect(workingImage, mouseClicks.get(0), mouseClicks.get(1), row, col, normFactor);

          if (recording) appendOperationToFile(recordingFileName, "LIQUIFY", liquifyParams);

          mouseClicks.clear();
        }
        break;
      case TWIST_LEFT:
        twistLeftEffect(workingImage, row, col, normFactor);

        if (recording) appendOperationToFile(recordingFileName, "TWIST_LEFT", params);

        break;
      case TWIST_RIGHT:
        twistRightEffect(workingImage, row, col, normFactor);

        if (recording) appendOperationToFile(recordingFileName, "TWIST_RIGHT", params);

        break;
      case PINCH:
        pinchEffect(workingImage, row, col, normFactor);

        if (recording) appendOperationToFile(recordingFileName, "PINCH", params);

        break;
      case BULGE:
        bulgeEffect(workingImage, row, col, normFactor);

        if (recording) appendOperationToFile(recordingFileName, "BULGE", params);

        break;
    }
  }

  /**
   * Display a GUI component to select a text file where the set of effect instructions is stored.
   */
  private static void executeFromFileButtonClicked() {
    FileFilter textFilter = new FileNameExtensionFilter("Text Files", "txt");
    JFileChooser fc = new JFileChooser();
    fc.setFileFilter(textFilter);
    int returnVal = fc.showOpenDialog(frame);

    if (returnVal == JFileChooser.APPROVE_OPTION) {
      File file = fc.getSelectedFile();

      executeFileInstructions(file.getAbsolutePath());
    }
  }

  /** Displays the GUI */
  public static void displayApp() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    Color[][] whiteImage = {{Color.WHITE}};

    ImageIcon icon = new ImageIcon(resizeImage(createImageFromPixelArray(whiteImage)));
    imageLabel = new JLabel();
    imageLabel.setIcon(icon);

    frame = new JFrame();
    frame.setLayout(new FlowLayout());
    frame.setSize(screenSize.width, screenSize.height);

    JButton selectImageButton = new JButton("Select Image");
    JButton readFileButton = new JButton("Execute Instructions (from file)");
    recordButton = new JButton("Record");
    JButton saveImageButton = new JButton("Save Image");

    ButtonGroup group = new ButtonGroup();
    JRadioButton liquifyButton = new JRadioButton("Liquify");
    JRadioButton twistLeftButton = new JRadioButton("Twist Left");
    JRadioButton twistRightButton = new JRadioButton("Twist Right");
    JRadioButton pinchButton = new JRadioButton("Pinch");
    JRadioButton bulgeButton = new JRadioButton("Bulge");
    group.add(liquifyButton);
    group.add(twistLeftButton);
    group.add(twistRightButton);
    group.add(pinchButton);
    group.add(bulgeButton);

    liquifyButton.setSelected(true);
    frame.add(selectImageButton);
    frame.add(readFileButton);
    frame.add(recordButton);
    frame.add(saveImageButton);
    frame.add(liquifyButton);
    frame.add(twistLeftButton);
    frame.add(twistRightButton);
    frame.add(pinchButton);
    frame.add(bulgeButton);
    frame.add(imageLabel);

    selectImageButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            readImageClicked();
          }
        });

    readFileButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            executeFromFileButtonClicked();
          }
        });

    recordButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            recordClicked();
          }
        });
    saveImageButton.addActionListener(
        new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
            saveImageClicked();
          }
        });

    liquifyButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            effectChanged(Effect.LIQUIFY);
          }
        });

    twistLeftButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            effectChanged(Effect.TWIST_LEFT);
          }
        });

    twistRightButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            effectChanged(Effect.TWIST_RIGHT);
          }
        });

    pinchButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            effectChanged(Effect.PINCH);
          }
        });

    bulgeButton.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            effectChanged(Effect.BULGE);
          }
        });

    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  /**
   * Changes the current effect when a radio button is clicked
   *
   * @param effect Selected effect
   */
  protected static void effectChanged(Effect effect) {

    currentEffect = effect;
    mouseClicks.clear();
  }

  /** Opens a file chooser to select an image */
  protected static void readImageClicked() {

    FileFilter imageFilter =
        new FileNameExtensionFilter("Image Files", ImageIO.getReaderFileSuffixes());

    JFileChooser fc = new JFileChooser();
    fc.setFileFilter(imageFilter);
    int returnVal = fc.showOpenDialog(frame);

    if (returnVal == JFileChooser.APPROVE_OPTION) {
      File file = fc.getSelectedFile();
      updateImage(readImage(file.getAbsolutePath()));
    }
  }

  /**
   * This method reads an image given its path
   *
   * @param filePath The path of the image to be read
   * @return A 2D array of pixels representing the image
   * @throws Exception Exception is thrown when the file does not exist
   */
  public static Color[][] readImage(String filePath) {
    File imageFile = new File(filePath);
    BufferedImage image;
    try {
      image = ImageIO.read(imageFile);
      image = resizeImage(image);

      Color[][] colors = new Color[image.getHeight()][image.getWidth()];

      for (int row = 0; row < image.getHeight(); row++) {
        for (int col = 0; col < image.getWidth(); col++) {
          colors[row][col] = new Color(image.getRGB(col, row));
        }
      }

      return colors;
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  /**
   * Method that resized the input image to 854x480
   *
   * @param Image Image to be resized
   * @return Resized image
   */
  public static BufferedImage resizeImage(BufferedImage image) {
    int width = 854;
    int height = 480;
    Image tmp = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    image = new BufferedImage(width, height, Image.SCALE_REPLICATE);
    image.getGraphics().drawImage(tmp, 0, 0, null);

    return image;
  }

  /**
   * This method receives a 2D array of pixel colors and returns its equivalent BufferedImage
   * representation
   *
   * @param imagePixels Pixel values of the image to be converted
   * @return BufferedImage representation of the input
   */
  public static BufferedImage createImageFromPixelArray(Color[][] imagePixels) {
    BufferedImage image =
        new BufferedImage(imagePixels[0].length, imagePixels.length, BufferedImage.TYPE_INT_RGB);

    for (int row = 0; row < image.getHeight(); row++) {
      for (int col = 0; col < image.getWidth(); col++) {
        image.setRGB(col, row, imagePixels[row][col].getRGB());
      }
    }

    return image;
  }
}
