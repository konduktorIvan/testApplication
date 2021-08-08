package org.test.example.testapplication.client.ui.application.shell.content.statusbar;

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
public final class StatusbarControllerCreatorImpl extends AbstractControllerCreator<TestApplicationContext> implements IsControllerCreator {
  public StatusbarControllerCreatorImpl(Router router, TestApplicationContext context,
      SimpleEventBus eventBus) {
    super(router, context, eventBus);
  }

  @Override
  public ControllerInstance create(String route) {
    ControllerInstance controllerInstance = new ControllerInstance();
    controllerInstance.setControllerCreator(this);
    controllerInstance.setControllerClassName("org.test.example.testapplication.client.ui.application.shell.content.statusbar.StatusbarController");
    AbstractComponentController<?, ?, ?> storedController = ControllerFactory.get().getControllerFormStore("org.test.example.testapplication.client.ui.application.shell.content.statusbar.StatusbarController");
    if (storedController == null) {
      StatusbarController controller = new StatusbarController();
      controllerInstance.setController(controller);
      controllerInstance.setCached(false);
      controller.setContext(context);
      controller.setEventBus(eventBus);
      controller.setRouter(router);
      controller.setCached(false);
      controller.setRelatedRoute(route);
      controller.setRelatedSelector("footer");
    } else {
      controllerInstance.setController(storedController);
      controllerInstance.setCached(true);
      controllerInstance.getController().setCached(true);
    }
    return controllerInstance;
  }

  @Override
  public void onFinishCreating(Object object) {
    StatusbarController controller = (StatusbarController) object;
    IStatusbarComponent component = new StatusbarComponent();
    component.setController(controller);
    controller.setComponent(component);
    component.render();
    component.bind();
  }

  @Override
  public void setParameter(Object object, String... params) throws RoutingInterceptionException {
  }
}
