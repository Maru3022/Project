import React from 'react';
import { Search, Filter, Plus } from 'lucide-react';

const mockBooks = [
    { id: 1, title: 'Темная Башня', author: 'Стивен Кинг', isbn: '978-5-17', status: 'В наличии', copies: 5 },
    { id: 2, title: '1984', author: 'Джордж Оруэлл', isbn: '978-5-18', status: 'Выдано', copies: 0 },
    { id: 3, title: 'Идиот', author: 'Фёдор Достоевский', isbn: '978-5-19', status: 'В наличии', copies: 12 },
];

const BookCatalog = () => {
    return (
        <div className="bg-white p-6 rounded-2xl shadow-xl font-sans">
            {/* Верхняя панель: Поиск, Фильтр, Кнопка Добавления */}
            <div className="flex justify-between items-center mb-6">
                <div className="flex space-x-3">
                    {/* Поле поиска с иконкой */}
                    <div className="relative">
                        <Search className="absolute left-3 top-1/2 transform -translate-y-1/2 w-5 h-5 text-gray-400" />
                        <input
                            type="text"
                            placeholder="Поиск по названию или автору..."
                            className="pl-10 pr-4 py-2 border border-gray-300 rounded-xl focus:border-indigo-primary focus:ring-1 focus:ring-indigo-primary transition duration-150 w-80"
                        />
                    </div>

                    {/* Кнопка фильтрации */}
                    <button className="flex items-center px-4 py-2 border border-gray-300 rounded-xl text-gray-600 hover:bg-gray-100 transition duration-150 shadow-sm">
                        <Filter className="w-5 h-5 mr-2" />
                        Фильтры
                    </button>
                </div>

                {/* Кнопка "Добавить" - Акцентный Коралл */}
                <button className="flex items-center px-4 py-2 bg-coral-accent text-white rounded-xl font-semibold shadow-lg shadow-coral-accent/50 hover:bg-orange-600 transition duration-200">
                    <Plus className="w-5 h-5 mr-2" />
                    Добавить Книгу
                </button>
            </div>

            {/* Таблица данных */}
            <div className="overflow-x-auto">
                <table className="min-w-full divide-y divide-gray-200">
                    <thead className="bg-gray-bg sticky top-0">
                    <tr>
                        {['Название', 'Автор', 'ISBN', 'Статус', 'Копии', 'Действия'].map((header) => (
                            <th key={header} className="px-6 py-3 text-left text-xs font-semibold text-gray-500 uppercase tracking-wider">
                                {header}
                            </th>
                        ))}
                    </tr>
                    </thead>
                    <tbody className="bg-white divide-y divide-gray-100">
                    {mockBooks.map((book) => (
                        <tr key={book.id} className="hover:bg-gray-50 transition duration-100">
                            <td className="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">{book.title}</td>
                            <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-700">{book.author}</td>
                            <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-500">{book.isbn}</td>
                            <td className="px-6 py-4 whitespace-nowrap">
                  <span className={`px-3 py-1 inline-flex text-xs leading-5 font-semibold rounded-full 
                    ${book.status === 'В наличии' ? 'bg-green-100 text-green-800' : 'bg-red-100 text-red-800'}`}>
                    {book.status}
                  </span>
                            </td>
                            <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-700">{book.copies}</td>
                            <td className="px-6 py-4 whitespace-nowrap text-sm font-medium">
                                <button className="text-indigo-primary hover:text-indigo-light mr-4 p-2 rounded-md hover:bg-indigo-50 transition duration-150">Изменить</button>
                                <button className="text-red-500 hover:text-red-700 p-2 rounded-md hover:bg-red-50 transition duration-150">Удалить</button>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default BookCatalog;