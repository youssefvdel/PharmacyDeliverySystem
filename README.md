# Pharmacy Delivery System - Group 39

Phase 3 Software Engineering I project.

## Status

Work in progress.

## Structure

```
├── database/              Derby DB schema + connection code
│   ├── schema.sql         CREATE TABLE statements (share this)
│   ├── seed_data.sql      Test data (share this)
│   └── DatabaseConnection.java
├── diagrams/              Fixed UML diagrams (Mermaid)
├── plan/                  Phase 3 planning documents
└── temp/                  Original Phase 1 & 2 files
```

## Database Sync (How to share between team)

**DON'T** commit database files to git. **DO** share the schema:

1. Everyone runs the same `schema.sql` locally
2. Everyone gets their own `pharmacyDB/` folder (auto-created)
3. Use `seed_data.sql` for consistent test data

### Setup

```bash
# 1. Start Derby ij
/opt/derby/bin/ij

# 2. Create database and run schema
ij> connect 'jdbc:derby:./database/pharmacyDB;create=true';
ij> run 'database/schema.sql';
ij> run 'database/seed_data.sql';
ij> exit;
```

### Java Connection

```java
Connection conn = DatabaseConnection.getConnection();
```

Uses **relative path** `./database/pharmacyDB` - works on everyone's machine.

## Deadline

Friday 24/4/2026
