package uz.master.warehouse.services.download;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import uz.master.warehouse.dto.payment.PaymentDto;
import uz.master.warehouse.services.organization.CompanyService;
import uz.master.warehouse.services.organization.OrganizationService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Objects;

@Service
public final class BetweenDatePdfService {
    private final OrganizationService organizationService;
    private final CompanyService companyService;

    public BetweenDatePdfService(OrganizationService organizationService,
                                 CompanyService companyService) {
        this.organizationService = organizationService;
        this.companyService = companyService;
    }


    public ByteArrayInputStream paymentReport(List<PaymentDto> paymentDtos,
                                              String fromDate,
                                              String toDate) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
//
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{1, 3, 3, 5, 3});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell cell1 = PdfPCell("T/R", headFont);
            table.addCell(cell1);

            PdfPCell cell2 = PdfPCell("Organization name", headFont);
            table.addCell(cell2);

            PdfPCell cell3 = PdfPCell("Company name", headFont);
            table.addCell(cell3);

            PdfPCell cell4 = PdfPCell("Date", headFont);
            table.addCell(cell4);

            PdfPCell cell5 = PdfPCell("Sum", headFont);
            table.addCell(cell5);

            for (int i = 0; i < paymentDtos.size(); i++) {
                PaymentDto payment = paymentDtos.get(i);

                String orgName = organizationService.getName(payment.getOrganizationId());
                String compName = companyService.getName(payment.getCompanyId());
                int year = payment.getDateTime().getYear();
                int month = payment.getDateTime().getMonthValue();
                int day = payment.getDateTime().getDayOfMonth();
                String date = year + "-" + month + "-" + day;

                PdfPCell(table, i + 1 + "");
                PdfPCell(table, orgName);
                PdfPCell(table, compName);
                PdfPCell(table, date);
                PdfPCell(table, payment.getSum().toString());
            }

//
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(new Paragraph(Element.ALIGN_JUSTIFIED_ALL, "Payment list between date " + fromDate + " and " + toDate + "\n\n\n"));
            document.add(table);
            document.close();

        } catch (DocumentException ex) {
            System.out.println("ex = " + ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }


    private static PdfPCell PdfPCell(String name, Font headFont) {
        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase(name, headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setBackgroundColor(BaseColor.CYAN);
        return hcell;
    }

    private static void PdfPCell(PdfPTable table, String book) {
        PdfPCell cell;
        cell = new PdfPCell(new Phrase(book));
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPaddingRight(10);
        table.addCell(cell);
    }

    public OrganizationService organizationService() {
        return organizationService;
    }

    public CompanyService companyService() {
        return companyService;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (BetweenDatePdfService) obj;
        return Objects.equals(this.organizationService, that.organizationService) &&
                Objects.equals(this.companyService, that.companyService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationService, companyService);
    }

    @Override
    public String toString() {
        return "BetweenDatePdfService[" +
                "organizationService=" + organizationService + ", " +
                "companyService=" + companyService + ']';
    }


}
