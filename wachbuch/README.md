# Elektronisches Wachbuch

Revisionssicheres digitales Dienstbuch für den Sicherheitsdienst – läuft komplett offline im Browser, keine Installation und kein Server nötig.

## Funktionen

- **Fortlaufend nummerierte Einträge** mit automatischem Zeitstempel, Objekt, Verfasser und Ereignisart (Schichtbeginn/-ende, Kontrollgang, Besonderes Vorkommnis, Alarm, Schlüsselausgabe, Besucher, Störung …)
- **Revisionssicher:** Einträge können nach dem Speichern nicht mehr geändert oder gelöscht werden. Korrekturen nur per **Storno-Vermerk** (Original bleibt durchgestrichen sichtbar – wie im Papier-Wachbuch)
- **SHA-256-Hash-Kette:** Jeder Eintrag ist kryptografisch mit dem vorherigen verkettet. Der Button „Kette prüfen" erkennt jede nachträgliche Manipulation
- **Filter & Suche** nach Zeitraum, Ereignisart und Freitext
- **CSV-Export** (öffnet direkt in Excel) und **Druck-/PDF-Ansicht** mit Unterschriftenfeldern für Wachhabenden und Objektleitung
- **Backup/Restore** als JSON-Datei
- **Mehrere Objekte** verwaltbar
- **PWA:** Auf dem Handy „Zum Startbildschirm hinzufügen" – funktioniert danach komplett offline

## Nutzung

`wachbuch/index.html` im Browser öffnen (oder über GitHub Pages aufrufen). Mitarbeitername eintragen, Objekt wählen, Einträge erfassen.

**Wichtig:** Die Daten liegen im Browser-Speicher (localStorage) des jeweiligen Geräts. Regelmäßig **Backup (JSON)** ziehen, z. B. am Schichtende zusammen mit dem CSV-Export.
