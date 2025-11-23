import React from 'react';
import { Search, Filter, Plus } from 'lucide-react';

const mockBooks = [
    { id: 1, title: 'Темная Башня', author: 'Стивен Кинг', isbn: '978-5-17', status: 'В наличии', copies: 5 },
    { id: 2, title: '1984', author: 'Джордж Оруэлл', isbn: '978-5-18', status: 'Выдано', copies: 0 },
    { id: 3, title: 'Идиот', author: 'Фёдор Достоевский', isbn: '978-5-19', status: 'В наличии', copies: 12 },
];

const BookCatalog = () => {
    return (
        <div className="bg-white/90 backdrop-blur-sm p-6 rounded-2xl shadow-2xl font-sans border-2 border-purple-200">
            {/* Верхняя панель: Поиск, Фильтр, Кнопка Добавления */}
            <div className="flex justify-between items-center mb-6">
                <div className="flex space-x-3">
                    {/* Поле поиска с иконкой */}
                    <div className="relative">
                        <Search className="absolute left-3 top-1/2 transform -translate-y-1/2 w-5 h-5" style={{ color: '#9333ea' }} />
                        <input
                            type="text"
                            placeholder="Поиск по названию или автору..."
                            className="pl-10 pr-4 py-2 border-2 border-purple-300 rounded-xl focus:border-purple-500 focus:ring-2 focus:ring-purple-300 transition duration-150 w-80 bg-white/80"
                            style={{ 
                                color: '#9333ea',
                                fontWeight: '500'
                            }}
                        />
                    </div>

                    {/* Кнопка фильтрации - Фиолетово-розовая */}
                    <button className="flex items-center px-4 py-2 bg-gradient-to-r from-purple-500 to-pink-500 text-white rounded-xl font-semibold shadow-lg shadow-purple-500/50 hover:from-purple-600 hover:to-pink-600 hover:shadow-xl transition duration-200 transform hover:scale-105" style={{ background: 'linear-gradient(to right, #a855f7, #ec4899)' }}>
                        <Filter className="w-5 h-5 mr-2" />
                        Фильтры
                    </button>
                </div>

                {/* Кнопка "Добавить" - Розово-фиолетовая */}
                <button className="flex items-center px-4 py-2 bg-gradient-to-r from-pink-500 to-purple-500 text-white rounded-xl font-semibold shadow-lg shadow-pink-500/50 hover:from-pink-600 hover:to-purple-600 hover:shadow-xl transition duration-200 transform hover:scale-105" style={{ background: 'linear-gradient(to right, #ec4899, #a855f7)' }}>
                    <Plus className="w-5 h-5 mr-2" />
                    Добавить Книгу
                </button>
            </div>

            {/* Таблица данных */}
            <div className="overflow-x-auto">
                <table className="min-w-full divide-y divide-purple-200">
                    <thead className="bg-gradient-to-r from-purple-500 to-pink-500 sticky top-0">
                    <tr>
                        {['Название', 'Автор', 'ISBN', 'Статус', 'Копии', 'Действия'].map((header) => (
                            <th key={header} className="px-6 py-3 text-left text-xs font-semibold text-white uppercase tracking-wider">
                                {header}
                            </th>
                        ))}
                    </tr>
                    </thead>
                    <tbody className="bg-white/50 divide-y divide-purple-100">
                    {mockBooks.map((book) => (
                        <tr key={book.id} className="hover:bg-gray-50 transition duration-100">
                            <td className="px-6 py-4 whitespace-nowrap text-sm font-medium" style={{ 
                                background: 'linear-gradient(to right, #9333ea, #db2777)',
                                WebkitBackgroundClip: 'text',
                                WebkitTextFillColor: 'transparent',
                                backgroundClip: 'text'
                            }}>{book.title}</td>
                            <td className="px-6 py-4 whitespace-nowrap text-sm" style={{ 
                                background: 'linear-gradient(to right, #db2777, #9333ea)',
                                WebkitBackgroundClip: 'text',
                                WebkitTextFillColor: 'transparent',
                                backgroundClip: 'text'
                            }}>{book.author}</td>
                            <td className="px-6 py-4 whitespace-nowrap text-sm" style={{ 
                                background: 'linear-gradient(to right, #a855f7, #ec4899)',
                                WebkitBackgroundClip: 'text',
                                WebkitTextFillColor: 'transparent',
                                backgroundClip: 'text'
                            }}>{book.isbn}</td>
                            <td className="px-6 py-4 whitespace-nowrap">
                  <span className={`px-3 py-1 inline-flex text-xs leading-5 font-semibold rounded-full shadow-md
                    ${book.status === 'В наличии' 
                        ? 'bg-gradient-to-r from-green-400 to-teal-400 text-white' 
                        : 'bg-gradient-to-r from-red-400 to-pink-400 text-white'}`}>
                    {book.status}
                  </span>
                            </td>
                            <td className="px-6 py-4 whitespace-nowrap text-sm font-semibold" style={{ 
                                background: 'linear-gradient(to right, #9333ea, #db2777)',
                                WebkitBackgroundClip: 'text',
                                WebkitTextFillColor: 'transparent',
                                backgroundClip: 'text'
                            }}>{book.copies}</td>
                            <td className="px-6 py-4 whitespace-nowrap text-sm font-medium">
                                <button className="bg-gradient-to-r from-purple-500 to-pink-500 text-white hover:from-purple-600 hover:to-pink-600 mr-4 px-4 py-2 rounded-lg font-semibold shadow-md shadow-purple-500/30 hover:shadow-lg transition duration-200 transform hover:scale-105" style={{ background: 'linear-gradient(to right, #a855f7, #ec4899)' }}>
                                    Изменить
                                </button>
                                <button className="bg-gradient-to-r from-pink-500 to-purple-500 text-white hover:from-pink-600 hover:to-purple-600 px-4 py-2 rounded-lg font-semibold shadow-md shadow-pink-500/30 hover:shadow-lg transition duration-200 transform hover:scale-105" style={{ background: 'linear-gradient(to right, #ec4899, #a855f7)' }}>
                                    Удалить
                                </button>
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