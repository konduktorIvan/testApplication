package org.test.example.testapplication.client;

import com.github.nalukit.nalu.client.application.IsLoader;
import com.github.nalukit.nalu.client.application.event.LogEvent;
import com.github.nalukit.nalu.client.internal.application.AbstractApplication;
import com.github.nalukit.nalu.client.internal.application.ControllerFactory;
import com.github.nalukit.nalu.client.internal.application.ShellFactory;
import com.github.nalukit.nalu.client.internal.route.RouteConfig;
import com.github.nalukit.nalu.client.internal.route.ShellConfig;
import com.github.nalukit.nalu.client.plugin.IsCustomAlertPresenter;
import com.github.nalukit.nalu.client.plugin.IsCustomConfirmPresenter;
import com.github.nalukit.nalu.client.tracker.IsTracker;
import java.lang.Override;
import java.util.Arrays;
import org.test.example.testapplication.client.ui.application.popup.error.ErrorComponent;
import org.test.example.testapplication.client.ui.application.popup.error.ErrorController;
import org.test.example.testapplication.client.ui.application.popup.error.IErrorComponent;

/**
 * Build with Nalu version >>2.5.0<< at >>2021.08.08-15:02:26<<
 */
public final class TestApplicationApplicationImpl extends AbstractApplication<TestApplicationContext> implements TestApplicationApplication {
  public TestApplicationApplicationImpl() {
    super();
    super.context = new org.test.example.testapplication.client.TestApplicationContext();
  }

  @Override
  public void loadLoggerConfiguration() {
  }

  @Override
  public void logProcessorVersion() {
    this.eventBus.fireEvent(LogEvent.create().sdmOnly(true).addMessage("=================================================================================").addMessage("Nalu processor version  >>2.5.0<< used to generate this source").addMessage("=================================================================================").addMessage(""));
  }

  @Override
  public IsTracker loadTrackerConfiguration() {
    return null;
  }

  @Override
  public void loadShells() {
    super.shellConfiguration.getShells().add(new ShellConfig("/application", "org.test.example.testapplication.client.ui.application.shell.ApplicationShell"));
  }

  @Override
  public void loadShellFactory() {
    ShellFactory.get().registerShell("org.test.example.testapplication.client.ui.application.shell.ApplicationShell", new org.test.example.testapplication.client.ui.application.shell.ApplicationShellCreatorImpl(router, context, eventBus));
  }

  @Override
  public void loadCompositeController() {
  }

  @Override
  public void loadComponents() {
    ControllerFactory.get().registerController("org.test.example.testapplication.client.ui.application.shell.content.statusbar.StatusbarController", new org.test.example.testapplication.client.ui.application.shell.content.statusbar.StatusbarControllerCreatorImpl(router, context, eventBus));
    ControllerFactory.get().registerController("org.test.example.testapplication.client.ui.application.shell.content.navigation.NavigationController", new org.test.example.testapplication.client.ui.application.shell.content.navigation.NavigationControllerCreatorImpl(router, context, eventBus));
    ControllerFactory.get().registerController("org.test.example.testapplication.client.ui.application.content.screen01.Screen01Controller", new org.test.example.testapplication.client.ui.application.content.screen01.Screen01ControllerCreatorImpl(router, context, eventBus));
    ControllerFactory.get().registerController("org.test.example.testapplication.client.ui.application.content.screen02.Screen02Controller", new org.test.example.testapplication.client.ui.application.content.screen02.Screen02ControllerCreatorImpl(router, context, eventBus));
  }

  @Override
  public void loadRoutes() {
    super.routerConfiguration.getRouters().add(new RouteConfig("/application", Arrays.asList(new String[]{}), "footer", "org.test.example.testapplication.client.ui.application.shell.content.statusbar.StatusbarController"));
    super.routerConfiguration.getRouters().add(new RouteConfig("/application", Arrays.asList(new String[]{}), "navigation", "org.test.example.testapplication.client.ui.application.shell.content.navigation.NavigationController"));
    super.routerConfiguration.getRouters().add(new RouteConfig("/application/screen01", Arrays.asList(new String[]{}), "content", "org.test.example.testapplication.client.ui.application.content.screen01.Screen01Controller"));
    super.routerConfiguration.getRouters().add(new RouteConfig("/application/screen02/*", Arrays.asList(new String[]{"value"}), "content", "org.test.example.testapplication.client.ui.application.content.screen02.Screen02Controller"));
  }

  @Override
  public void loadBlockControllerFactory() {
  }

  @Override
  public void loadPopUpControllerFactory() {
  }

  @Override
  public void loadPopUpFilters() {
  }

  @Override
  public void loadErrorPopUpController() {
    ErrorController errorPopUpController = new ErrorController();
    errorPopUpController.setContext(context);
    errorPopUpController.setEventBus(eventBus);
    errorPopUpController.setRouter(router);
    IErrorComponent component = new ErrorComponent();
    component.setController(errorPopUpController);
    errorPopUpController.setComponent(component);
    component.render();
    component.bind();
    errorPopUpController.bind();
    errorPopUpController.onLoad();
  }

  @Override
  public void loadFilters() {
  }

  @Override
  public void loadHandlers() {
  }

  @Override
  public void loadCompositeReferences() {
  }

  @Override
  public void loadModules() {
    super.onFinishModuleLoading();
  }

  @Override
  public IsLoader<TestApplicationContext> getLoader() {
    return null;
  }

  @Override
  public IsLoader<TestApplicationContext> getPostLoader() {
    return null;
  }

  @Override
  public IsCustomAlertPresenter getCustomAlertPresenter() {
    return null;
  }

  @Override
  public IsCustomConfirmPresenter getCustomConfirmPresenter() {
    return null;
  }

  @Override
  public void loadDefaultRoutes() {
    this.startRoute = "/application/screen01";
  }

  @Override
  public void loadIllegalRouteTarget() {
    this.illegalRouteTarget = "";
  }

  @Override
  public boolean hasHistory() {
    return true;
  }

  @Override
  public boolean isUsingHash() {
    return true;
  }

  @Override
  public boolean isUsingColonForParametersInUrl() {
    return false;
  }

  @Override
  public boolean isStayOnSide() {
    return false;
  }

  @Override
  public boolean isRemoveUrlParameterAtStart() {
    return false;
  }
}
