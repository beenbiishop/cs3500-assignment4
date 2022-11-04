package model;

import java.awt.Color;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the {@link StoredImagesImpl} class and its methods.
 */
public class StoredImagesImplTest {

  private Color[][] pixels1;
  private Color[][] pixels2;
  private Image image1;
  private Image image2;
  private StoredImages store1;
  private StoredImages store2;

  @Before
  public void setUp() {
    this.pixels1 = new Color[3][2];
    this.pixels2 = new Color[12][27];

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 2; j++) {
        Color pixel;
        if (i == 0) {
          pixel = Color.RED;
        } else if (i == 1) {
          pixel = Color.GREEN;
        } else {
          pixel = Color.BLUE;
        }
        this.pixels1[i][j] = pixel;
      }
    }

    for (int i = 0; i < 12; i++) {
      for (int j = 0; j < 27; j++) {
        this.pixels2[i][j] = Color.BLACK;
      }
    }

    this.image1 = new ImageImpl(this.pixels1);
    this.image2 = new ImageImpl(this.pixels2);

    this.store1 = new StoredImagesImpl();
    this.store1.add("image1", this.image1, true);
    this.store1.add("image2", this.image2, true);

    this.store2 = new StoredImagesImpl();
  }

  @Test
  public void add() {
  }

  @Test
  public void remove() {
  }

  @Test
  public void exists() {
  }

  @Test
  public void retrieve() {
  }
}