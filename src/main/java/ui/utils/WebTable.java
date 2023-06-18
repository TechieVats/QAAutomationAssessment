package ui.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WebTable {
    private WebElement tableElement;
    private List<WebElement> headerColumns;
    private List<List<WebElement>> rowData;

    public WebTable(WebElement tableElement) {
        this.tableElement = tableElement;
        this.headerColumns = getHeaderColumns();
        this.rowData = getRowData();
    }

    private List<WebElement> getHeaderColumns() {
        List<WebElement> headerColumns = new ArrayList<>();
        List<WebElement> headerCells = tableElement.findElements(By.cssSelector("th[ng-repeat*='column']"));

        for (WebElement headerCell : headerCells) {
            String columnName = headerCell.getText();
            if (!columnName.isEmpty()) {
                headerColumns.add(headerCell);
            }
        }

        return headerColumns;
    }

    private List<List<WebElement>> getRowData() {
        List<List<WebElement>> rowData = new ArrayList<>();
        List<WebElement> rows = tableElement.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            rowData.add(cells);
        }
        return rowData;
    }

    public int getRowCount() {
        return rowData.size();
    }

    public int getColumnCount() {
        return headerColumns.size();
    }

    public String getColumnName(int columnIndex) {
        return headerColumns.get(columnIndex).getText();
    }

    public String getCellData(int rowIndex, int columnIndex) {
        List<WebElement> rowCells = rowData.get(rowIndex);
        return rowCells.get(columnIndex).getText();
    }

    public List<String> getColumnData(String columnName) {
        List<String> columnData = new ArrayList<>();
        int columnIndex = getColumnIndex(columnName);
        for (List<WebElement> rowCells : rowData) {
            if (columnIndex < rowCells.size()) {
                columnData.add(rowCells.get(columnIndex).getText());
            }
        }
        return columnData;
    }

    public int getColumnIndex(String columnName) {
        for (int i = 0; i < headerColumns.size(); i++) {
            String headerText = headerColumns.get(i).getText();
            if (headerText.equalsIgnoreCase(columnName)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Column '" + columnName + "' not found in the table.");
    }

    public boolean isColumnDataUnique(String columnName) {
        List<String> columnData = getColumnData(columnName);
        Set<String> uniqueData = new HashSet<>(columnData);
        return columnData.size() == uniqueData.size();
    }

    public boolean isUserPresentInColumn(String username) {
        List<String> columnData = getColumnData("User Name");
        return columnData.contains(username);
    }

}

