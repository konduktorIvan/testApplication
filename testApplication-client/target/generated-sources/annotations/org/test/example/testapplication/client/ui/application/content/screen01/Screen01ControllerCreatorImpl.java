package org.test.example.testapplication.client.ui.application.content.screen01;

import com.github.nalukit.nalu.client.Router;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.exception.RoutingInterceptionException;
import com.github.nalukit.nalu.client.internal.AbstractControllerCreator;
import com.github.nalukit.nalu.client.internal.application.ControllerFactory;
import com.github.nalukit.nalu.client.internal.application.ControllerInstance;
import com.github.nalukit.nalu.client.internal.application.IsControllerCreator;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import org.gwtproject.event.shared.SimpleEventBus;
import org.test.example.testapplication.client.TestApplicationContext;

/**
 * Build with Nalu version >>2.5.0<< at >>2021.08.08-15:02:26<<
 */
public final class Screen01ControllerCreatorImpl extends AbstractControllerCreator<TestApplicationContext> implements IsControllerCreator {
  public Screen01ControllerCreatorImpl(Router router, TestApplicationContext context,
      SimpleEventBus eventBus) {
    super(router, context, eventBus);
  }

  @Override
  public ControllerInstance create(String route) {
    ControllerInstance controllerInstance = new ControllerInstance();
    controllerInstance.setControllerCreator(this);
    controllerInstance.setControllerClassName("org.test.example.testapplication.client.ui.application.content.screen01.Screen01Controller");
    AbstractComponentController<?, ?, ?> storedController = ControllerFactory.get().getControllerFormStore("org.test.example.testapplication.client.ui.application.content.screen01.Screen01Controller");
    if (storedController == null) {
      Screen01Controller controller = new Screen01Controller();
      controllerInstance.setController(controller);
      controllerInstance.setCached(false);
      controller.setContext(context);
      controller.setEventBus(eventBus);
      controller.setRouter(router);
      controller.setCached(false);
      controller.setRelatedRoute(route);
      controller.setRelatedSelector("content");
    } else {
      controllerInstance.setController(storedController);
      controllerInstance.setCached(true);
      controllerInstance.getController().setCached(true);
    }
    return controllerInstance;
  }

  @Override
  public void onFinishCreating(Object object) {
    Screen01Controller controller = (Screen01Controller) object;
    IScreen01Component component = new Screen01Component();
    component.setController(controller);
    controller.setComponent(component);
    component.render();
    component.bind();
  }

  @Override
  public void setParameter(Object object, String... params) throws RoutingInterceptionException {
  }
}
