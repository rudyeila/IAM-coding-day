# Use Case


1. Produkte auf Nutzer (Identität) anpassen, indiviudelle Vorschläge
2. Hobbys und Alter mit einbeziehen
    - Geburtstag Reiseversicherung 
    - Einbinden von Reisemöglichkeiten (Booking.com)    
3. Wohnortwechsel -> neue Versicherung (Hausrat,..) 
    - Als Portal darauf reagieren
4. User an "Warenkorb" erinnern
5. Upselling -> passende Versicherung (Haftpflicht, Hausrat), Reiseschutz, Reisekrankenversicherung
6. Mitgliedsbonus Angebote bei x Jahren Kunde, Rewarding System -> customerSince
7. Stufenmodell bei den Preisen
8. Umgang mit healthFile -> Preise an Geschichte des Users anpassen?
9. Arten von Versicherungen an Beruf knüpfen 
10. customArray -> abgeschlossene Produkte? JSON in customArray?


# MVP 
- Reagieren auf veränderte Hobbys
    - User loggt sich ein, Hobbys werden in Datenbank zwischengespeichert
    - Abgleich bei Login zwischen alten und neuen Hobbys
        - Falls sich etwas geändert hat, schlage neue Versicherung vor 
 
# Zuständigkeiten

| Typ | Technologien | Zuständig |
| ------ | ------ |------ |
| Frontend | Angular | Plamena, Niklas |
| Backend | Java | Rudy, Alex, Frank |
| IAM   | -  | Niklas, Rudy |

# OIDC Client
Client ID: **superapp**
Password: **wirklichsupersicher**

