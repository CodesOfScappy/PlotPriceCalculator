# Grundstückspreisrechner

Der Grundstückspreisrechner ist ein Java-Programm, das den Gesamtpreis für ein Grundstück basierend auf seinen Abmessungen und dem Preis pro Quadratmeter berechnet. 
Der Rechner bietet auch Funktionen zur Berechnung der Provision und der Mehrwertsteuer. 
Dieses Programm wurde von David Maurin erstellt und befindet sich in der `PlotPriceCalculator`-Klasse.

## Funktionalität und Verwendung

Das Programm ermöglicht es dem Benutzer, die Länge, Breite und den Preis pro Quadratmeter für ein Grundstück einzugeben. 
Anhand dieser Eingaben werden der Grundstückspreis, der Gesamtpreis inklusive Provision und der Gesamtpreis inklusive Provision und Mehrwertsteuer berechnet und angezeigt.

## Verwendung

1. Das Programm fordert den Benutzer auf, die Länge, Breite und den Preis pro Quadratmeter einzugeben.
2. Die eingegebenen Werte werden zur Berechnung des Grundstückspreises, der Provision und der Mehrwertsteuer verwendet.
3. Die berechneten Ergebnisse werden im Konsolenfenster angezeigt, inklusive des Grundstückspreises, 
   des Gesamtpreises inklusive Provision und des Gesamtpreises inklusive Provision und Mehrwertsteuer.

## Methodenübersicht

- `main`: Die Hauptmethode des Programms, die den Benutzer durch die Eingabeaufforderungen führt und die Berechnungen durchführt.
- `readPositiveBigDecimalInput`: Methode zur Eingabe einer positiven BigDecimal-Zahl durch den Benutzer.
- `calculatePlotPrice`: Berechnet den Gesamtpreis des Grundstücks basierend auf den Abmessungen und dem Preis pro Quadratmeter.
- `calculateCommission`: Berechnet die Provision basierend auf dem Grundstückspreis.
- `calculateVAT`: Berechnet die Mehrwertsteuer basierend auf einem angegebenen Betrag.
- `calculateTotalCost`: Berechnet die Gesamtkosten inklusive Mehrwertsteuer.

## Autor und Version

Das Programm wurde von David Maurin erstellt und befindet sich in Version 1.0.

## Hinweis

Dieses Programm wurde für die Ausführung in einer Konsolenumgebung entwickelt. Die Eingabe erfolgt über die Konsole, und die Ergebnisse werden ebenfalls dort angezeigt.

## Lizenz

Dieses Programm ist unter [MIT-Lizenz](https://opensource.org/licenses/MIT) veröffentlicht. Siehe `LICENSE`-Datei für weitere Informationen.

**Hinweis:** Dieses Programm dient nur zu Bildungszwecken und zur Demonstration von Java-Programmierfähigkeiten. 
Die berechneten Ergebnisse könnten in der Praxis von tatsächlichen Preisen abweichen, und es wird empfohlen, 
professionelle Beratung in Anspruch zu nehmen, bevor finanzielle Entscheidungen getroffen werden.
