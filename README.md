# PortScanner
A basic Java port scanner that scans an IP address for open ports and logs results in a file.

📌 Features
✔️ Scans a given IP for open ports.
✔️ Uses multi-threading for fast scanning.
✔️ Saves results in scan_results.txt.

🔧 Usage
1️⃣ Compile the Java file:

bash
Copy
Edit
javac portscanner.java
2️⃣ Run the scanner:

bash
Copy
Edit
java portscanner <IP Address> <Start Port> <End Port>
Example:

bash
Copy
Edit
java portscanner 192.168.1.1 20 100
3️⃣ View Scan Results:

bash
Copy
Edit
type scan_results.txt   # Windows
cat scan_results.txt    # Linux/macOS
📂 Project Structure
bash
Copy
Edit
PortScanner/
│── portscanner.java       # Java source code
│── scan_results.txt       # Scan logs (generated automatically)
│── README.md              # Documentation
⚠️ Disclaimer
Use this tool only for educational purposes and on authorized networks. Unauthorized scanning may violate laws or company policies.

