package org.test.example.testapplication.client.ui.application.shell;

import com.github.nalukit.nalu.client.Router;
import com.github.nalukit.nalu.client.exception.RoutingInterceptionException;
import com.github.nalukit.nalu.client.internal.AbstractShellCreator;
import com.github.nalukit.nalu.client.internal.application.IsShellCreator;
import com.github.nalukit.nalu.client.internal.application.ShellInstance;
import java.lang.Override;
import org.gwtproject.event.shared.SimpleEventBus;
import org.test.example.testapplication.client.TestApplicationContext;

/**
 * Build with Nalu version >>2.5.0<< at >>2021.08.08-15:02:26<<
 */
public final class ApplicationShellCreatorImpl extends AbstractShellCreator<TestApplicationContext> implements IsShellCreator {
  public ApplicationShellCreatorImpl(Router router, TestApplicationContext context,
      SimpleEventBus eventBus) {
    super(router, context, eventBus);
  }

  @Override
  public ShellInstance create() {
    ShellInstance shellInstance = new ShellInstance();
    shellInstance.setShellClassName("org.test.example.testapplication.client.ui.application.shell.ApplicationShell");
    ApplicationShell shell = new ApplicationShell();
    shellInstance.setShell(shell);
    shell.setContext(context);
    shell.setEventBus(eventBus);
    shell.setRouter(router);
    return shellInstance;
  }

  @Override
  public void onFinishCreating() throws RoutingInterceptionException {
  }
}
