package de.codeofscappy.calculator;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Die Klasse PlotPriceCalculator berechnet den Gesamtpreis für ein Grundstück
 * basierend auf seinen Abmessungen und dem Preis pro Quadratmeter. Sie enthält
 * auch Berechnungen für die Provision und die Mehrwertsteuer.
 *
 * @author David Maurin
 * @version 1.0
 */
public class PlotPriceCalculator {

	/**
	 * Die main-Methode berechnet und zeigt den Grundstückspreis, den Gesamtpreis
	 * inklusive Provision und den Gesamtpreis inklusive Provision und
	 * Mehrwertsteuer an.
	 *
	 * @param args Die Befehlszeilenargumente (nicht verwendet).
	 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("#############################");
		System.out.println(" Grundstückspreis Berechnung ");
		System.out.println("#############################");

		System.out.print("Bitte geben Sie die Länge des Grundstücks in Metern ein: ");
		BigDecimal length = readPositiveBigDecimalInput(scanner);

		System.out.print("Bitte geben Sie die Breite des Grundstücks in Metern ein: ");
		BigDecimal width = readPositiveBigDecimalInput(scanner);

		System.out.print("Bitte geben Sie den Preis pro Quadratmeter in Euro(€) ein: ");
		BigDecimal pricePerSquareMeter = readPositiveBigDecimalInput(scanner);

		scanner.close();

		BigDecimal plotPrice = calculatePlotPrice(length, width, pricePerSquareMeter);
		BigDecimal commission = calculateCommission(plotPrice);
		BigDecimal totalWithCommission = plotPrice.add(commission);
		BigDecimal vatOnCommission = calculateVAT(commission);
		BigDecimal totalWithVAT = totalWithCommission.add(vatOnCommission);

		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		System.out.println("Grundstückspreis: " + decimalFormat.format(plotPrice) + " €");
		System.out.println("Grundstückspreis inkl. 5% Provision: " + decimalFormat.format(totalWithCommission) + " €");
		System.out.println("Grundstückspreis inkl. 5% Provision und 19% Mehrwertsteuer: "
				+ decimalFormat.format(totalWithVAT) + " €");
	}

	/**
	 * Liest positive BigDecimal-Eingaben vom angegebenen Scanner.
	 *
	 * @param scanner Der Scanner, der für die Eingabe verwendet wird.
	 * @return Ein positiver BigDecimal-Wert, den der Benutzer eingegeben hat.
	 */
	public static BigDecimal readPositiveBigDecimalInput(Scanner scanner) {
		while (true) {
			try {
				BigDecimal value = new BigDecimal(scanner.nextLine());
				if (value.compareTo(BigDecimal.ZERO) > 0) {
					return value;
				} else {
					System.out.print("Ungültige Eingabe. Bitte geben Sie eine positive Zahl ein: ");
				}
			} catch (NumberFormatException e) {
				System.out.print("Ungültige Eingabe. Bitte geben Sie eine gültige Zahl ein: ");
			}
		}
	}

	/**
	 * Berechnet den Gesamtpreis des Grundstücks basierend auf seinen Abmessungen
	 * und dem Preis pro Quadratmeter.
	 *
	 * @param length              Die Länge des Grundstücks in Metern.
	 * @param width               Die Breite des Grundstücks in Metern.
	 * @param pricePerSquareMeter Der Preis pro Quadratmeter in Euro(€).
	 * @return Der Gesamtpreis des Grundstücks.
	 */
	public static BigDecimal calculatePlotPrice(BigDecimal length, BigDecimal width, BigDecimal pricePerSquareMeter) {
		return length.multiply(width).multiply(pricePerSquareMeter);
	}

	/**
	 * Berechnet den Provisionsbetrag basierend auf dem Grundstückspreis.
	 *
	 * @param plotPrice Der Gesamtpreis des Grundstücks.
	 * @return Der Provisionsbetrag.
	 */
	public static BigDecimal calculateCommission(BigDecimal plotPrice) {
		final BigDecimal COMMISSION_RATE = new BigDecimal("0.05"); // 5% Provision
		return plotPrice.multiply(COMMISSION_RATE);
	}

	/**
	 * Berechnet den Mehrwertsteuerbetrag basierend auf dem angegebenen Betrag.
	 *
	 * @param amount Der Betrag, für den die Mehrwertsteuer berechnet werden soll.
	 * @return Der Mehrwertsteuerbetrag.
	 */
	public static BigDecimal calculateVAT(BigDecimal amount) {
		final BigDecimal VAT_RATE = new BigDecimal("0.19"); // 19% Mehrwertsteuer
		return amount.multiply(VAT_RATE);
	}

	/**
	 * Berechnet die Gesamtkosten inklusive Mehrwertsteuer basierend auf dem
	 * angegebenen Gesamtbetrag.
	 *
	 * @param totalWithCommission Der Gesamtbetrag inklusive Provision.
	 * @return Die Gesamtkosten inklusive Mehrwertsteuer.
	 */
	public static BigDecimal calculateTotalCost(BigDecimal totalWithCommission) {
		final BigDecimal VAT_RATE = new BigDecimal("0.19"); // 19% Mehrwertsteuer
		return totalWithCommission.multiply(BigDecimal.ONE.add(VAT_RATE));
	}
}
