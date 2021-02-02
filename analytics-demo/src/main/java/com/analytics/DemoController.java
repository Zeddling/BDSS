package com.analytics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class DemoController {
    private static final Logger log = LoggerFactory.getLogger( DemoController.class );

    @Autowired
    PreprocessorProxy preprocessorProxy;

    @GetMapping("/index")
    public String index(Model model) {
	model.addAttribute("fileUpload", new FileUpload());
        model.addAttribute("state", "No prediction yet!");
        return "index";
    }

    @PostMapping("/predict")
    public String getImage(Model model, @ModelAttribute FileUpload fileUpload ) {
        MultipartFile multipartFile = fileUpload.getFile();
        PreprocessedMat results = preprocessorProxy.getPreprocessedImage(multipartFile);
        if (results == null) {
            log.info("Nothing to see here lol");
            model.addAttribute("state", null);
        }  else {
            log.info( "Results " + results.toString() );
            model.addAttribute("state", results);
        }
        return "predict";
    }

    private File multipartToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {
        File convFile = new File(System.getProperty("java.io.tmpdir")+"/"+fileName);
        multipart.transferTo(convFile);
        return convFile;
    }

}
