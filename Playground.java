import java.util.Arrays;
import java.util.Scanner;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaFileObject;

public class Playground {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        while (true) {
            System.out.print("Enter Java code (or 'exit' to quit): ");
            String code = scanner.nextLine();

            if (code.equalsIgnoreCase("exit")) {
                break;
            }

            String className = "DynamicClass";
            String sourceCode = "public class " + className + " { public static void main(String[] args) { " + code + " } }";

            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
            JavaFileObject file = (JavaFileObject) new SourceFileObject(className, sourceCode);

            Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null, null, diagnostics, null, null, compilationUnits);
            boolean success = task.call();

            if (success) {
                try {
                    Class<?> clazz = Class.forName(className);
                    clazz.getMethod("main", String[].class).invoke(null, (Object) null);
                } catch (Exception e) {
                    System.out.println("Error executing code: " + e.getMessage());
                }
            } else {
                System.out.println("Error compiling code");
                diagnostics.getDiagnostics().forEach(System.out::println);
            }
        }

        scanner.close();
    }

    static class SourceFileObject extends SimpleJavaFileObject {
        private final String sourceCode;

        SourceFileObject(String name, String sourceCode) {
            super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
            this.sourceCode = sourceCode;
        }

        @Override
        public CharSequenceReader openReader(boolean ignoreEncodingErrors) {
            return new CharSequenceReader(sourceCode);
        }
    }
}