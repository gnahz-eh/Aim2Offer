#include <string.h>
#include <stdlib.h>

class CMyString {

public:
	CMyString(char* pData = NULL);
	CMyString(const CMyString& str);
	~CMyString(void);
	CMyString& operator =(const CMyString& str);
private:
	char* m_pData;
};

CMyString& CMyString::operator =(const CMyString& str) {
	if (this == &str)
		return *this;

	delete []m_pData;
	m_pData = NULL;

	m_pData = new char[strlen(str.m_pData)+1];
	strcpy(m_pData, str.m_pData);

	return *this;
}