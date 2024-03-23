from datetime import datetime

def add_note(notes, title, body):
    note_id = max([note["id"] for note in notes]) + 1 if notes else 1
    notes.append({
        "id": note_id,
        "title": title,
        "body": body,
        "timestamp": datetime.now().strftime("%Y-%m-%d %H:%M")
    })
    return notes

def edit_note(notes, note_id, title=None, body=None):
    for note in notes:
        if note["id"] == note_id:
            if title:
                note["title"] = title
            if body:
                note["body"] = body
            note["timestamp"] = datetime.now().strftime("%Y-%m-%d %H:%M")
            return True, notes
    return False, notes

def delete_note(notes, note_id):
    notes = [note for note in notes if note["id"] != note_id]
    return notes

def list_notes(notes, filter_date=None):
    filtered_notes = [note for note in notes if filter_date is None or note["timestamp"].startswith(filter_date)]
    return filtered_notes