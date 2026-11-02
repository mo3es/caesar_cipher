# Caesar Cipher

A simple educational Java project implementing the classic Caesar cipher algorithm for text encryption, decryption, and cryptanalysis.

---

## 📌 About the Project

This project was created for educational purposes to practice core software development concepts (string manipulation, character processing, alphabet shifting, DAO pattern) and working with the Git version control system.

**Key Features:**
- 🔒 **Encryption:** Encoding text with a specified key (shift).
- 🔓 **Decryption:**
  - Restoring text using a known key.
  - Automated recovery via **Brute Force**.
  - Automated recovery via **Frequency Analysis**.
- 🌐 **Alphabet Support:** Handles both Cyrillic (Ukrainian, Russian) and Latin (English, Polish, German, French, Spanish) alphabets (preserving character case and punctuation).
- 🧪 **Testing:** Fully covered with JUnit 5 unit tests.

---

## 🛠 Tech Stack

- **Programming Language:** Java 17+
- **Build Tool:** Apache Maven (Shade Plugin for Fat JAR packaging)
- **Testing Framework:** JUnit 5

---

## 🚀 How to Run the Project

### Option A: Quick Start (Ready-to-use JAR)
If you just want to run the application without building from source:
1. Download the latest pre-built `caesar-cipher-1.0-SNAPSHOT.jar` from the [Releases page](https://github.com/mo3es/caesar_cipher/releases).
2. Make sure you have **Java 17+** installed.
3. Run the application via terminal (as described in step 4 below):

### Option B:
### 1. Clone the repository
```bash
git clone [https://github.com/mo3es/caesar_cipher.git](https://github.com/mo3es/caesar_cipher.git)
cd caesar_cipher
```
### 2. Run unit tests (Optional)
```bash

mvn clean test
```

### 3. Build the executable JAR
```bash

mvn clean package
```

This will generate a self-contained caesar-cipher-1.0-SNAPSHOT.jar inside the target/ directory.

### 4. Run the application
```bash

java -jar target/caesar-cipher-1.0-SNAPSHOT.jar [mode] [source_file_path] [destination_file_path] [key]
```

Available Modes:

    encrypt / e — Encrypt text with a key

    decrypt / d — Decrypt text with a key

    brute-force / brute — Automated recovery using word frequency

    frequency-analysis / freq — Automated recovery using character statistics

Note: If you run the jar without arguments, the interactive command-line mode will start.



📄 License

This project is licensed under the MIT License.

Copyright (c) 2026 Mykhailo BAILO
