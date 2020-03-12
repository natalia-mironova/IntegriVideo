package tests;

import org.testng.annotations.Test;

public class FileUploadModalTests extends BaseTest {
    @Test
    //ЗАГРУЗИТЬ 1 ФАЙЛ
    public void uploadFile() {
        //open page
        //click Drag&Drop
        //upload file
        //click 'Start'
        fileUploadModal.openPage();
        fileUploadModal.fileUploadModalOpen();
        fileUploadModal.uploadFile("src/main/resources/Homework1.docx");
        fileUploadModal.startClick();
    }

    @Test
    //ЗАГРУЗИТЬ 2 ФАЙЛА
    public void uploadFiles() {
        fileUploadModal.openPage();
        fileUploadModal.fileUploadModalOpen();
        fileUploadModal.uploadFile("src/main/resources/Homework1.docx",
                "src/main/resources/Homework2.docx");
        fileUploadModal.startClick();
    }
}
