package sample.java.project;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * The starting point of the application
 */
@NoArgsConstructor
@AllArgsConstructor
public class SampleJavaProject implements Runnable {

    private static final long PRINT_DELAY = 1000L;

    @Getter @Setter @NonNull
    @Parameter(names = "--name", description = "set the user's name",
               required = true)
    private String name = "world";

    @Parameter(names = "--loop", description = "print endlessly, hotswap demo")
    private boolean loop = false;

    @Parameter(names = { "-h", "--help" }, description = "print help message")
    private boolean help = false;

    /**
     * Print the "Hello, world!" string.
     */
    public static void main(final String[] args) {
        /* Parse command line arguments. */
        SampleJavaProject sjp = new SampleJavaProject();
        try {
            JCommander jc = new JCommander(sjp, args);
            if (sjp.help) {
                jc.usage();
                return;
            }
        } catch (ParameterException e) {
            System.err.println("error: " + e.getMessage());
            new JCommander(new SampleJavaProject()).usage();
            System.exit(-1);
        }

        sjp.run();
    }

    /**
     * Print the "Hello, world!" string.
     */
    public final void sayHello() {
        System.out.printf("Hello, %s!%n", name);
    }

    @Override
    public final void run() {
        do {
            sayHello();
            try {
                Thread.sleep(PRINT_DELAY);
            } catch (InterruptedException e) {
                return;
            }
        } while (loop);
    }
}
