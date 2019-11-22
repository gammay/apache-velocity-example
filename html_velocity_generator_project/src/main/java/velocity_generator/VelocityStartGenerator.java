package velocity_generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

public class VelocityStartGenerator {
 
	static String inputTemplate = "http_example.vm";
	static String message = "Hello World!";
	static String outputFile = "helloworld.html";
	
    public static void main(String[] args) throws IOException {
    	
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();
      
        VelocityContext context = new VelocityContext();
        context.put("message", message);

        Writer writer = new FileWriter(new File(outputFile));
        Velocity.mergeTemplate(inputTemplate
        		, "UTF-8", context, writer);
        writer.flush();
        writer.close();
        
        System.out.println("Generated " + outputFile);
    }
}
