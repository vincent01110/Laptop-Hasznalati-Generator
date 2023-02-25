package com.main.laptop_hasznalati;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.io.image.ImageData;

import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class MainController {

    @FXML
    TextField nameField;

    @FXML
    TextField idField;

    @FXML
    TextField typeField;

    @FXML
    TextField pNumberField;

    @FXML
    TextField snField;


    public void saveToPDF() throws IOException {
        hasznalati();
        kiviteli();

    }

    public void hasznalati(){
        try{
            String path = System.getProperty("user.home") + "\\Desktop\\" + nameField.getText() + "(" + idField.getText() + ")_hasznalati.pdf";
            PdfWriter pdfWriter = new PdfWriter(path);

            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            pdfDocument.addNewPage();
            Document document = new Document(pdfDocument, PageSize.A4);

            String logoPath = "src/main/resources/com/main/laptop_hasznalati/Schaeffler_logo.svg.png";
            ImageData imageData = ImageDataFactory.create(logoPath);
            Image logo = new Image(imageData).scale(0.05f, 0.05f);

            String regularFont = "src/main/resources/com/main/laptop_hasznalati/open-sans/OpenSans-Regular.ttf";
            String boldFont = "src/main/resources/com/main/laptop_hasznalati/open-sans/OpenSans-Bold.ttf";
            PdfFont bold = PdfFontFactory.createFont(boldFont, "ISO-8859-2", true);
            PdfFont font = PdfFontFactory.createFont(regularFont, "ISO-8859-2", true);

            Text name = new Text(nameField.getText()).setFont(bold);
            Text id = new Text(idField.getText()).setFont(bold);
            Text type = new Text(typeField.getText()).setFont(bold);
            Text pNumber = new Text(pNumberField.getText().toUpperCase()).setFont(bold);
            Text sn = new Text(snField.getText().toUpperCase()).setFont(bold);


            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("YYYY.MM.dd");

            Style titleStyle = new Style().setFontSize(24f).setFont(font)
                    .setMarginBottom(26f)
                    .setMarginTop(14f);

            Paragraph topLogo = new Paragraph().add(logo).setTextAlignment(TextAlignment.RIGHT);

            Paragraph title = new Paragraph(new Text("Laptop Használati Engedély").addStyle(titleStyle)).setTextAlignment(TextAlignment.CENTER);

            Paragraph mainText = new Paragraph()
                    .add(name)
                    .add(new Text(" (").setFont(font))
                    .add(id)
                    .add(new Text(") a ").setFont(font))
                    .add(pNumber)
                    .add(new Text(" számú ").setFont(font))
                    .add(sn)
                    .add(new Text(" gyári számú, ").setFont(font))
                    .add(type)
                    .add(new Text(" típusú laptopot tartozékaival együtt, (táska, egér, hálózati adapter) átvette."))
                    .add(new Text("\nA használati engedély "))
                    .add(new Text(dateFormat.format(LocalDate.now())).setFont(bold))
                    .add(new Text(". - határozatlan").setFont(bold))
                    .add(new Text(" időtartamra szól.").setFont(font));

            Paragraph signatures = new Paragraph()
                    .add(new Text("Átadó: .................................................               ").setFont(font))
                    .add(new Text("Átvevő: .................................................\n").setFont(font))
                    .add(new Text("\n\nDátum:\n\n").setFont(font))
                    .add(new Text("--------------------------------------------------------------------------------------------------------").setFont(font))
                    .setMarginTop(40f);

            Paragraph returned = new Paragraph()
                    .add(new Text("Az eszköz sérülésmentesen, hiánytalanul visszahozva:").setFont(font))
                    .add(new Text("\n\n\nÁtvevő: ....................................").setFont(font))
                    .add(new Text("\n\nDátum:").setFont(font))
                    .setMarginTop(20f);


            document.add(topLogo);
            document.add(title);
            document.add(mainText);
            document.add(signatures);
            document.add(returned);
            document.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void kiviteli() throws IOException {
            String path = System.getProperty("user.home") + "\\Desktop\\" + nameField.getText() + "(" + idField.getText() + ")_kiviteli.pdf";
            PdfWriter pdfWriter = new PdfWriter(path);

            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            pdfDocument.addNewPage();
            Document document = new Document(pdfDocument, PageSize.A4);

            String logoPath = "src/main/resources/com/main/laptop_hasznalati/Schaeffler_logo.svg.png";
            ImageData imageData = ImageDataFactory.create(logoPath);
            Image logo = new Image(imageData).scale(0.05f, 0.05f);

            String regularFont = "src/main/resources/com/main/laptop_hasznalati/open-sans/OpenSans-Regular.ttf";
            String boldFont = "src/main/resources/com/main/laptop_hasznalati/open-sans/OpenSans-Bold.ttf";
            PdfFont bold = PdfFontFactory.createFont(boldFont, "ISO-8859-2", true);
            PdfFont font = PdfFontFactory.createFont(regularFont, "ISO-8859-2", true);

            Text name = new Text(nameField.getText()).setFont(bold);
            Text id = new Text(idField.getText()).setFont(bold);
            Text type = new Text(typeField.getText()).setFont(bold);
            Text pNumber = new Text(pNumberField.getText().toUpperCase()).setFont(bold);
            Text sn = new Text(snField.getText().toUpperCase()).setFont(bold);


            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("YYYY.MM.dd");

            Style titleStyle = new Style().setFontSize(24f).setFont(font)
                    .setMarginBottom(26f)
                    .setMarginTop(14f);

            Paragraph topLogo = new Paragraph().add(logo).setTextAlignment(TextAlignment.RIGHT);

            Paragraph title = new Paragraph(new Text("Laptop Kiviteli Engedély").addStyle(titleStyle)).setTextAlignment(TextAlignment.CENTER);

            Paragraph mainParagraph = new Paragraph()
                    .add(new Text("Engedélyezem, hogy ").setFont(font))
                    .add(name)
                    .add(new Text(" (").setFont(font))
                    .add(id)
                    .add(new Text(") a ").setFont(font))
                    .add(pNumber)
                    .add(new Text(" számú ").setFont(font))
                    .add(sn)
                    .add(new Text(" gyári számú, ").setFont(font))
                    .add(type)
                    .add(new Text(" típusú laptopot tartozékaival együtt, (táska, egér, hálózati adapter) a gyár területéről "))
                    .add(new Text(dateFormat.format(LocalDate.now())).setFont(bold))
                    .add(new Text(". - határozatlan ideig").setFont(bold))
                    .add(new Text(" kivigye.")).setFont(font)
                    .setMarginBottom(60f);

            Paragraph signature = new Paragraph()
                    .add(new Text(".................................................................... IJXFAH-\n").setFont(font))
                    .add(new Text("                  Szegmens vezető (engedélyező)").setFont(font))
                    .setMarginBottom(20f);

            Paragraph date = new Paragraph()
                    .add(new Text("Dátum: ......................................\n").setFont(font))
                    .setTextAlignment(TextAlignment.RIGHT)
                    ;

            document.add(topLogo);
            document.add(title);
            document.add(mainParagraph);
            document.add(signature);
            document.add(date);
            document.close();


    }

}