package org.test.example.testapplication.client.ui.application.content.screen02;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.AcceptParameter;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.google.gwt.user.client.Timer;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import org.test.example.testapplication.client.TestApplicationContext;
import org.test.example.testapplication.client.event.StatusChangeEvent;
import org.test.example.testapplication.client.ui.application.content.screen02.helper.Wrapper;

import java.util.ArrayList;
import java.util.List;

@Controller(route = "/application/screen02/:value",
            selector = "content",
            componentInterface = IScreen02Component.class,
            component = Screen02Component.class)
public class Screen02Controller
    extends AbstractComponentController<TestApplicationContext, IScreen02Component, HTMLElement>
    implements IScreen02Component.Controller {

  private int           value;
  private List<Wrapper> listToSort;
  public List<Wrapper> getListToSort() {
	return listToSort;
}
//private int low, high;
  public Screen02Controller() {
    this.listToSort = new ArrayList<>();
  }
  private Timer t = new Timer() {
		//private Object container;
		//private List<Wrapper> listToSort = getListToSort();

		@Override
		public void run() {
			component.edit(listToSort);
		}
	};
  @Override
  public void start() {
    this.createData();

    component.edit(this.listToSort);
    // update the statusbar at the bottom of the screen
    eventBus.fireEvent(new StatusChangeEvent("active screen: >>Screen02<<"));
  }

  private void createData() {
    this.listToSort.clear();
    for (int i = 0; i < this.value; i++) {
      Wrapper wrapper = new Wrapper(this.getRandom());
      listToSort.add(wrapper);
    }
  }

  private int getRandom() {
    return (int) (Math.random() * (1000 - 1)) + 1;
  }

  @AcceptParameter("value")
  public void setValue(String value) {
    try {
      this.value = Integer.parseInt(value);
    } catch (NumberFormatException e) {
      this.value = 0;
    }
  }

  @Override
  public void doSort()  {
	
		doSort(this.listToSort, 0, this.listToSort.size()-1);
		
	  }
  
  
  
@Override
  public void doSort(List list, int low, int high)  {
	
		
		
	   int middle = low + (high - low) / 2;
	   int pivot = this.listToSort.get(middle).getRadomNumber();
	   
	    // разделить на подмассивы, который больше и меньше опорного элемента
	    int i = low, j = high;
	    while (i <= j) {
	        while (this.listToSort.get(i).getRadomNumber() < new Wrapper(pivot).getRadomNumber()) {
	            i++;
	        }

	        while (this.listToSort.get(j).getRadomNumber() > new Wrapper(pivot).getRadomNumber()) {
	            j--;
	        }

	        if (i <= j) {//меняем местами
	            Wrapper temp = this.listToSort.get(i);
	            this.listToSort.set(i, this.listToSort.get(j));
	            this.listToSort.set(j,temp);
	            i++;
	            j--;
	            t.schedule(1000);
	            //component.edit(this.listToSort);
	        }
	    }

	    // вызов рекурсии для сортировки левой и правой части
	    if (low < j)
	        doSort(this.listToSort, low, j);

	    if (high > i)
	      doSort(this.listToSort, i, high);
	    

  }
}
