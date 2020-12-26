import org.grails.gsp.GroovyPagesTemplateEngine
import groovy.text.*
class DemoController {
    GroovyPagesTemplateEngine groovyPagesTemplateEngine

    def demo () {
	// Create gsp on a path with a short size
	// The gsp contains a deliberate error
	def gspFile=new File("/tmp/test.gsp")
	gspFile.text='''<html><body><h1>Test</h1><g:nonexistingtag/></body></html>'''
	// Create the template
	def t = groovyPagesTemplateEngine.createTemplate(gspFile)
        StringWriter writer = new StringWriter()
	// Run the template. This will throw a java.lang.StringIndexOutOfBoundsException
        t.make([:]).writeTo(writer)
        def s= writer.toString()
        render(text:s,contentType: "text/html", encoding: "UTF-8")
    }
} 

