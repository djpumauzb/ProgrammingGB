import argparse
from file_operations import load_notes, save_notes
from note_operations import add_note, edit_note, delete_note, list_notes

def run_app():
    parser = argparse.ArgumentParser(description="Управление заметками")
    parser.add_argument('command', choices=['add', 'edit', 'delete', 'list'], help="Команда")
    parser.add_argument('--title', help="Заголовок заметки")
    parser.add_argument('--body', help="Тело заметки")
    parser.add_argument('--id', type=int, help="ID заметки")
    parser.add_argument('--date', help="Фильтр по дате (YYYY-MM-DD)")
    parser.add_argument('--file', default='notes.json', help="Файл для хранения заметок")
    args = parser.parse_args()

    notes = load_notes(args.file)

    if args.command == 'add':
        assert args.title and args.body, "Заголовок и тело заметки обязательны для добавления"
        notes = add_note(notes, args.title, args.body)
    elif args.command == 'edit':
        success, notes = edit_note(notes, args.id, args.title, args.body)
        if not success:
            print("Заметка не найдена")
    elif args.command == 'delete':
        notes = delete_note(notes, args.id)
    elif args.command == 'list':
        for note in list_notes(notes, args.date):
            print(f'{note["id"]}: {note["title"]} - {note["timestamp"]}')

    save_notes(args.file, notes)

if __name__ == '__main__':
    run_app()