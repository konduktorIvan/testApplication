package org.test.example.testapplication.client.ui.application.content.screen02;

import java.util.List;

import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.cards.HeaderAction;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.DominoElement;
import org.test.example.testapplication.client.ui.application.content.screen02.helper.MyWidget;
import org.test.example.testapplication.client.ui.application.content.screen02.helper.Wrapper;

import com.github.nalukit.nalu.client.component.AbstractComponent;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;

public class Screen02Component
    extends AbstractComponent<IScreen02Component.Controller, HTMLElement>
    implements IScreen02Component {

  private Card                          card;
  private DominoElement<HTMLDivElement> container;
  
  public Screen02Component() {
    super();
  }

  @Override
  public void edit(List<Wrapper> listToDisplay){
    card.setTitle("Your Number is: " + listToDisplay.size());

    this.container.remove();
    this.container = DominoElement.div();
    this.card.appendChild(this.container);

    DominoElement<HTMLDivElement> column  = null;
    int                           index = 0;
    for (Wrapper m : listToDisplay) {
      if (column == null || index > 9) {
        if (column != null) {
        	
        	//Thread.sleep(5000);
          this.container.appendChild(column);
        }
        column   = DominoElement.div()
                             .styler(style -> style.setWidth("110px")
                                                   .setMaxWidth("110px")
                                                   .setMinWidth("110px")
                                                   .setHeight("300px")
                                                   .setMinHeight("500px")
                                                   .setMaxHeight("500px")
                                                   .setFloat("left")
                                                   .setColor("RED"));
        index = 0;
      }

      MyWidget myWigdet = MyWidget.create()
                                  .number(m.getRadomNumber());

      column.appendChild(myWigdet.element());

      index++;
    }
    this.container.appendChild(column);
    //this.container
  }

  
  
  
  @Override
  public void render() {
    card           = Card.create("")
                         .styler(style -> style.setWidth("1312px")
                                               .setMaxWidth("1312px")
                                               .setMinWidth("1312px")
                                               .setHeight("1000px") )
                         .addHeaderAction(HeaderAction.create(Icons.ALL.sort_variant_mdi()
                                                                       .setTooltip("Start Sort")
                                                                       .addClickListener(e -> getController()
                                                                       .doSort())));
                                                                    		   //.doSort(new Screen02Controller().getListToSort(), 0, new Screen02Controller().getListToSort().size()-1)
    this.container = DominoElement.div();
    this.card.appendChild(this.container);
    
    initElement(card.element());
  }
}
