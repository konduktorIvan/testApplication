package org.test.example.testapplication.client.ui.application.content.screen02.helper;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;

public class MyWidget {

  private int    number;

  private DominoElement<HTMLDivElement> container;
  private DominoElement<HTMLDivElement> textContainer;

  public MyWidget() {
    this.textContainer = DominoElement.div();
    this.container     = DominoElement.div()
                                      .styler(style -> style.setWidth("100px")
                                                            .setHeight("32px")
                                                            .setMargin("10px")
                                                            .setBackgroundColor(Color.INDIGO.getHex())
                                                            .setTextAlign("center")
                                                            .setFloat("left")
                                                            .setPadding("6px")
                                                            .setColor(Color.WHITE.getHex())
                                                            .setProperty("font-weight",
                                                                         "bold")
                                                            .setProperty("font-color",
                                                                         "white"))
                                      .appendChild(this.textContainer);
  }

  public static MyWidget create() {
    MyWidget widget = new MyWidget();
    return widget;
  }

  public MyWidget number(int number) {
    this.number = number;
    this.textContainer.appendChild(TextNode.of(String.valueOf(number)));
    return this;
  }

  public MyWidget active() {
    this.container.styler(style -> style.setColor(Color.RED.getHex()));
    return this;
  }

  public MyWidget sorted() {
    this.container.styler(style -> style.setColor(Color.GREEN.getHex()));
    return this;
  }

  public HTMLDivElement element() {
    return this.container.element();
  }

}
