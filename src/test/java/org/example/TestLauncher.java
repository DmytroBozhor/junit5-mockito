package org.example;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.PrintWriter;

public class TestLauncher {

    public static void main(String[] args) {

        // default launcher to run our tests
        var launcher = LauncherFactory.create();

        // it is like scan path in the spring framework
        // we have to specify the place where our tests are
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(DiscoverySelectors.selectPackage("org.example"))
                .build();

        // for the statistics output (how many tests failed and succeeded)
        var summaryGeneratingListener = new SummaryGeneratingListener();

        // execute our tests
        launcher.execute(request, summaryGeneratingListener);

        // to pring out statistic to the console
        try (var printWriter = new PrintWriter(System.out)) {
            summaryGeneratingListener.getSummary().printTo(printWriter);
        }
    }

}
