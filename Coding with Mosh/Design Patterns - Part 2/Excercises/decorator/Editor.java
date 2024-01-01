package com.codewithmosh.decorator;

public class Editor {
    public void openProject(String path) {
        ArtefactDecorator[] artefacts = {
                new Artefact("Main"),
                new Artefact("Demo"),
                new Artefact("EmailClient"),
                new Artefact("EmailProvider"),
        };

        artefacts[2] =  new ErrorDecorator (artefacts[2]);
        artefacts[0] = new MainDecorator(artefacts[0]);

        for (var artefact : artefacts)
            System.out.println(artefact.render());
    }
}
